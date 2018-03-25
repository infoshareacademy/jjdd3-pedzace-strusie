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
import java.util.*;

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
            logger.error("Template add-category is not found {}", e.getMessage());
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
            logger.info("Put new category into data model");

            req.getSession().removeAttribute("errors");
            req.getSession().removeAttribute("category");
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error("Template add-category is not found {}", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.findById(((User) req.getSession().getAttribute("user")).getId());

        Category newCategory = new Category();
        String categoryName = req.getParameter("name").toLowerCase();

        if (categoryDao.findByCategoryName(categoryName, user).isPresent()) {
            newCategory = categoryDao.findByCategoryName(categoryName, user).get();
            logger.debug("Category {} is already in DB...", newCategory.getCategory());
        } else {
            newCategory.setCategory(categoryName);
            newCategory.setActive(true);
            newCategory.setDefault(false);
            newCategory.setUser((User) req.getSession().getAttribute("user"));
            logger.debug("User is: {}", user);

            categoryDao.save(newCategory);
            logger.debug("Adding new category {} to DB...", newCategory);
        }

        user.getCategories().add(newCategory);
        userDao.update(user);
        logger.debug("User is {}", req.getSession().getAttribute("user"));

        resp.sendRedirect("/categories-list");
    }
}
