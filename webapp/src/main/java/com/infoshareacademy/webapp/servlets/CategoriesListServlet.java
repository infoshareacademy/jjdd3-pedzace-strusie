package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao_lockal.CategoryDaoLoc;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

@WebServlet("/categories-list")
public class CategoriesListServlet extends HttpServlet {

    @EJB
    CategoryDaoLoc categoryDaoLoc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<String> categoryList = categoryDaoLoc.findAll();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("categories", categoryList);

        Template template = TemplateProvider.createTemplate(getServletContext(), "categories-list.ftlh");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
