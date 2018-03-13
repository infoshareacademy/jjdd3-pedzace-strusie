package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao_lockal.StatisticsDaoLoc;
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

@WebServlet("/by-categories")
public class ByCategoriesServlet extends HttpServlet {

    @EJB
    StatisticsDaoLoc statisticsDaoLoc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Double> stringDoubleMap = statisticsDaoLoc.findExpensesByCategory();
        Double sumExpenses = statisticsDaoLoc.findSumExpenses();
        Double sumIncomes = statisticsDaoLoc.findSumIncomes();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("maps", stringDoubleMap.entrySet());
        dataModel.put("sumExpenses", sumExpenses);
        dataModel.put("sumIncomes", sumIncomes);

        Template template = TemplateProvider.createTemplate(getServletContext(), "by-categories.ftlh");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}