package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao.ExpenseDao;
import com.infoshareacademy.webapp.dao_lockal.CategoryDaoLoc;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Expense;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
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


@WebServlet("/add-expense")

public class AddExpenseServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AddExpenseServlet.class);

    private Template template;

    @EJB
    private ExpenseDao expenseDao;

    @EJB
    CategoryDaoLoc categoryDaoLoc;


    @Override
    public void init() throws ServletException {

        try {
            template = TemplateProvider.createTemplate(getServletContext(), "expense-service.ftlh");
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
            req.getSession().removeAttribute("errors");
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Expense expense = new Expense();
        expense.setDate(LocalDate.parse(req.getParameter("date")));
        expense.setCategory(req.getParameter("category"));
        expense.setExpense(Double.parseDouble(req.getParameter("expense")));

        expenseDao.save(expense);

        resp.sendRedirect("/");// tutaj należy wstawić odnośnik do servletu odpowiedzialnego za
        // wyświetlanie wydatków użytkownika
    }
}
