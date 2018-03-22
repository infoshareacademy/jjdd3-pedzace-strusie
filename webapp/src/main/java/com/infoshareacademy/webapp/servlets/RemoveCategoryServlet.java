package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao_lockal.CategoryDaoLoc;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/remove-category")
@MultipartConfig
public class RemoveCategoryServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(RemoveCategoryServlet.class);

    private Template template;

    @EJB
    CategoryDaoLoc categoryDaoLoc;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "remove-category.ftlh");
        } catch (IOException e) {
            logger.error(e.getMessage());
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
        String removeCategory = "";
        removeCategory = req.getParameter("name");
        logger.debug("Get removing category {}", removeCategory.toUpperCase());

        categoryDaoLoc.delete(removeCategory.toLowerCase());
        resp.sendRedirect("/categories-list");
    }
}
