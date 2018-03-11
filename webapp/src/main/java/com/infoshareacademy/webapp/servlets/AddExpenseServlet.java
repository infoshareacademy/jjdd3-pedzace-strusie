package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.baseapp.Expense;
import com.infoshareacademy.webapp.dao.ExpenseDaoBean;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/add-expense")
public class AddExpenseServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    Template template;

    @EJB
    ExpenseDaoBean expenseDaoBean;


    @Override
    public void init() throws ServletException {

        try {
            template = TemplateProvider.createTemplate(getServletContext(), "expense-service.ftlh");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Expense expense = new Expense();
        expense.setDate(LocalDate.parse(req.getParameter("date")));
        expense.setCategory(req.getParameter("category"));
        expense.setExpense(Double.parseDouble(req.getParameter("expense")));

        expenseDaoBean.save(expense);

        resp.sendRedirect("/");// tutaj należy wstawić odnośnik do servletu odpowiedzialnego za
        // wyświetlanie wydatków użytkownika
    }
}
