package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao.ExpenseDao;
import com.infoshareacademy.webapp.dao_lockal.StatisticsDaoLoc;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Expense;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/by-months")
public class ByMonthsServlet extends HttpServlet {

    @EJB
    StatisticsDaoLoc statisticsDaoLoc;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Double> stringDoubleMap = statisticsDaoLoc.findExpensesByMonths();
        Double sumExpenses = statisticsDaoLoc.findSumExpenses();
        Double sumIncomes = statisticsDaoLoc.findSumIncomes();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("maps", stringDoubleMap.entrySet());
        dataModel.put("sumExpenses", sumExpenses);
        dataModel.put("sumIncomes", sumIncomes);
        dataModel.put("chartData", getChartData());  // odpowiada za rysowanie wykresu;

        Template template = TemplateProvider.createTemplate(getServletContext(), "by-months.ftlh");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }


    private Map<String, Double> getChartData() {

        Map data = new HashMap<String, Double>();
        data.put("dla dzieci", 320.2d);
        data.put("jedzenie", 12.2d);
        data.put("paliwo", 350.50d);
        data.put("mieszkanie", 520d);

        return data;
    }


}
