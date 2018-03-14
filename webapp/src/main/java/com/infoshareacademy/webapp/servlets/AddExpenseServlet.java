package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.baseapp.Expense;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/add-expense")
//@MultipartConfig

public class AddExpenseServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(getClass().getName());

    Template template;

    @EJB
    private ExpenseDaoBean expenseDaoBean;


    @Override
    public void init() throws ServletException {

        try {
            template = TemplateProvider.createTemplate(getServletContext(), "expense-service.ftlh");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");
        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            dataModel.put("user", req.getSession().getAttribute("user"));
            req.getSession().removeAttribute("error");
            req.getSession().removeAttribute("user");
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Expense expense = new Expense();
        expense.setDate(LocalDate.parse(req.getParameter("date")));
        expense.setCategory(req.getParameter("category"));
        expense.setExpense(Double.parseDouble(req.getParameter("expense")));

//        expenseDaoBean.addExpense(expense);

        resp.sendRedirect("/budget/add-expense");// tutaj należy wstawić odnośnik do servletu odpowiedzialnego za
        // wyświetlanie wydatków użytkownika
    }
}
