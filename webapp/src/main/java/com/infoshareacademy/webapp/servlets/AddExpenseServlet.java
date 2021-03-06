package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao.CategoryDao;
import com.infoshareacademy.webapp.dao.ExpenseDao;
import com.infoshareacademy.webapp.dao.UserDao;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Category;
import model.Expense;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/budget/add-expense")
@MultipartConfig
public class AddExpenseServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private Template template;

    @EJB
    private UserDao userDao;

    @EJB
    private ExpenseDao expenseDao;

    @EJB
    private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {

        try {
            template = TemplateProvider.createTemplate(getServletContext(), "add-expense.ftlh");
        } catch (IOException e) {
            logger.error("Template add-expense is not found {}", e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.findById(((User) req.getSession().getAttribute("user")).getId());

        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");
        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            logger.info("Put errors into data model");

            req.getSession().removeAttribute("errors");
            req.getSession().removeAttribute("expense");
        } else {
            List<Category> categoryList = new ArrayList<>();
            if (categoryDao.findAllByUser(user).isPresent()) {
                categoryList = (List<Category>) categoryDao.findAllByUser(user).get();
                logger.debug("Category list is set as: {}", categoryList);
            }

            logger.debug("Category list is {}", categoryList);
            dataModel.put("categories", categoryList);
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
        expense.setUser((User) req.getSession().getAttribute("user"));
        logger.debug("Expense date is set as: {}", expense.getDate());
        logger.debug("Expense value is set as: {}", expense.getExpense());
        logger.debug("Expense user is set as: {}", expense.getUser());
        logger.debug("User ID is set as: {}", expense.getUser().getId());

        expenseDao.save(expense);

        resp.sendRedirect("/budget/start");

    }
}
