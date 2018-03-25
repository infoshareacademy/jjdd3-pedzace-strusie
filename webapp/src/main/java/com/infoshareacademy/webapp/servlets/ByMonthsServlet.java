package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao.StatisticsDao;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/by-months")
public class ByMonthsServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private Template template;

    @Inject
    StatisticsDao statisticsDao;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "list-by-months.ftlh");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Double> stringDoubleMap = statisticsDao.findExpensesByMonths();
        Double sumExpenses = statisticsDao.findSumExpenses();
        Double sumIncomes = statisticsDao.findSumIncomes();

        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("maps", stringDoubleMap.entrySet());
        dataModel.put("sumExpenses", sumExpenses);
        dataModel.put("sumIncomes", sumIncomes);

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.warn("Template Exceptions {}",e.getMessage());
        }
    }
}
