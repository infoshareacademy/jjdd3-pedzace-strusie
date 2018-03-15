package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao_lockal.MapRepositoryDao;
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

@WebServlet("/map-list")
public class MapListServlet extends HttpServlet {

    @EJB
    MapRepositoryDao mapRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Double,String> hm = mapRepositoryDao.getUsersMap();



        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("users", hm.entrySet());
        dataModel.put("sumEx", 1500);
        dataModel.put("sumIn", 4800);


        Template template = TemplateProvider.createTemplate(getServletContext(), "map-list.ftlh");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
