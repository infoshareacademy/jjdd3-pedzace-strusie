package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao_lockal.CategoryDaoLoc;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
    private static final Logger logger = LoggerFactory.getLogger(RestoreCategoryServlet.class);

    private Template template;

    @EJB
    CategoryDaoLoc categoryDaoLoc;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "restore-category.ftlh");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Get restore category");

        categoryDaoLoc.update();
        resp.sendRedirect("/categories-list");
    }
}


