package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao.CategoryDao;
import com.infoshareacademy.webapp.dao.UserDao;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Category;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/add-category")
@MultipartConfig
public class AddCategoryServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private Template template;

    @EJB
    private CategoryDao categoryDao;

    @Inject
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "add-category.ftlh");
        } catch (IOException e) {
            logger.error("Template add-category is not found {}",e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");
        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            dataModel.put("category", req.getSession().getAttribute("category"));
            logger.info("Put category into data model");

            req.getSession().removeAttribute("error");
            req.getSession().removeAttribute("category");
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category newCategory = new Category();

        User user = userDao.findById(((User) req.getSession().getAttribute("user")).getId());

        String categoryName = req.getParameter("name").toLowerCase();

        if (categoryDao.findByCategoryName(categoryName).isPresent()){
            logger.debug("Category {} is already in DB...", categoryDao.findByCategoryName(categoryName).get().getCategory());
            newCategory = categoryDao.findByCategoryName(categoryName).get();
        } else {
            newCategory.setCategory(categoryName);
            newCategory.setActive(true);
            newCategory.setDefault(false);
            categoryDao.save(newCategory);
            logger.debug("Adding new category {} to DB...", newCategory);
        }

        logger.debug("User id {}", req.getSession().getAttribute("user"));

        user.getCategories().add(newCategory);
        userDao.update(user);

        resp.sendRedirect("/categories-list");
    }
}
