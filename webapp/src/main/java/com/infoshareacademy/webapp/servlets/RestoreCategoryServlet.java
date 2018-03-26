package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao.CategoryDao;
import com.infoshareacademy.webapp.dao.UserDao;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/restore-category")
public class RestoreCategoryServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private Template template;

    @EJB
    CategoryDao categoryDao;

    @EJB
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "restore-category.ftlh");
        } catch (IOException e) {
            logger.error("Template by-categories is not found {}",e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.findById(((User) req.getSession().getAttribute("user")).getId());

        logger.debug("Get restore category");

        categoryDao.restoreByUser(user);
        resp.sendRedirect("/list-categories");
    }
}


