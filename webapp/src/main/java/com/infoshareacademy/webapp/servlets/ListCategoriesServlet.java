package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao.CategoryDao;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/list-categories")
//@Transactional
public class ListCategoriesServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private Template template;

    @EJB
    private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "list-categories.ftlh");
        } catch (IOException e) {
            logger.error("Template by-categories is not found {}", e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = categoryDao.findAll();

        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        logger.debug("Category list is {}", categoryList);
        dataModel.put("categories", categoryList);

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.warn("Template Exceptions {}", e.getMessage());
        }
    }
}
