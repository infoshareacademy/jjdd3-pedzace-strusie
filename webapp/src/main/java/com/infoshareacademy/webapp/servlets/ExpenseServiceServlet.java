package com.infoshareacademy.webapp.servlets;


import com.infoshareacademy.baseapp.Expense;
import com.infoshareacademy.webapp.cdi.FileUploadProcessorBean;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ExpenseServiceServlet")
@MultipartConfig
public class ExpenseServiceServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    File templatesPath;
    Template template;

    @Inject
    FileUploadProcessorBean fileUploadProcessorBean;

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
        expense.setExpense(Double.parseDouble("expense"));

      //  expensesRepositoryDao.addExpense(expense);

        Part filePart = req.getPart("/resources");
        File file = null;

        try {
            file = fileUploadProcessorBean.uploadFinanceSourceFile();
        }

        resp.sendRedirect("/");




    }
}
