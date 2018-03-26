package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao.IncomeDao;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Income;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/budget/get-expensesbycat")
public class GetExpensesByCatServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private Template template;

    @EJB
    private IncomeDao incomeDao;

    @Override
    public void init() throws ServletException {

        try {
            template = TemplateProvider.createTemplate(getServletContext(), "get-expenses-by-categories.ftlh");
        } catch (IOException e) {
            logger.error("Template get-expenses-by-categories is not found {}", e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");
        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            req.getSession().removeAttribute("errors");
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error("Template get-expenses-by-categories is not found {}", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocalDate minDatePeriod = LocalDate.parse(req.getParameter("minDatePeriod"));
        LocalDate maxDatePeriod = LocalDate.parse(req.getParameter("maxDatePeriod"));

        logger.debug("Min Date Period is set as: {}", minDatePeriod);
        logger.debug("Max Date Period is set as: {}", maxDatePeriod);

        req.getSession().setAttribute("minDatePeriod",minDatePeriod);
        req.getSession().setAttribute("maxDatePeriod",maxDatePeriod);

        resp.sendRedirect("/budget/by-categories");
    }
}
