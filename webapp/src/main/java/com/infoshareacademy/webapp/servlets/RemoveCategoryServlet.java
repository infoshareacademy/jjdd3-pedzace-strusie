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

@WebServlet("/budget/remove-category")
@MultipartConfig
public class RemoveCategoryServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private Template template;

    @EJB
    private CategoryDao categoryDao;

    @EJB
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "remove-category.ftlh");
        } catch (IOException e) {
            logger.error("Template remove-category is not found {}", e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.findById(((User) req.getSession().getAttribute("user")).getId());

        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");
        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            dataModel.put("category", req.getSession().getAttribute("removeCategory"));
            logger.info("Put removing category into data model");

            req.getSession().removeAttribute("errors");
            req.getSession().removeAttribute("removeCategory");
        } else {
            List<Category> categoryList = new ArrayList<>();
            if (categoryDao.findAllByUser(user).isPresent()) {
                categoryList = (List<Category>) categoryDao.findAllByUser(user).get();
                logger.debug("Category list is set as: {}", categoryList);
            }

            logger.debug("Category list is {}", categoryList);
            dataModel.put("categories", categoryList);
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error("Template remove-category is not found {}", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.findById(((User) req.getSession().getAttribute("user")).getId());

        Category removeCategory = new Category();
        String categoryName = req.getParameter("category").toLowerCase();
        logger.debug("Remove category is {}", removeCategory);
        logger.debug("Category name is{}", categoryName);

        if (categoryDao.findByCategoryName(user, categoryName).isPresent()) {
            removeCategory = categoryDao.findByCategoryName(user, categoryName).get();
            logger.debug("Category to remove {} is already in DB...", removeCategory.getCategory());

            removeCategory.setActive(false);
            categoryDao.update(removeCategory);
            logger.debug("Adding new category {} to DB...", removeCategory);
        }
        resp.sendRedirect("/budget/start");
    }
}
