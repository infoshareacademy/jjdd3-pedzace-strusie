package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.dao.ExpenseDao;
import com.infoshareacademy.webapp.dao.IncomeDao;
import com.infoshareacademy.webapp.dao.StatisticsDao;
import com.infoshareacademy.webapp.dao.UserDao;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Expense;
import model.Income;
import model.User;
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
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/by-months")
public class ByMonthsServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private Template template;

    @Inject
    private ExpenseDao expenseDao;

    @Inject
    private IncomeDao incomeDao;

    @EJB
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "list-by-months.ftlh");
        } catch (IOException e) {
            logger.error("Template by-months is not found {}", e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.findById(((User) req.getSession().getAttribute("user")).getId());

        LocalDate minDatePeriod = (LocalDate) req.getSession().getAttribute("minDatePeriod");
        LocalDate maxDatePeriod = (LocalDate) req.getSession().getAttribute("maxDatePeriod");

        logger.debug("Min Date Period is set as: {}", minDatePeriod);
        logger.debug("Max Date Period is set as: {}", maxDatePeriod);

        List<Expense> periodExpensesList = new ArrayList<>();
        Map<String, Double> stringDoubleMap = new TreeMap<>();

        if (expenseDao.findByExpenseByPeriod(user, minDatePeriod, maxDatePeriod).isPresent()) {
            periodExpensesList = (List<Expense>) expenseDao.findByExpenseByPeriod(user, minDatePeriod, maxDatePeriod).get();
            logger.debug("Expenses period list is set as: {}", periodExpensesList);

            Map<String, Double> mapByCategories = periodExpensesList.stream()
                    .collect(Collectors.groupingBy(e -> String.format("%d, %tm(%s)", e.getDate().getYear(), e.getDate().getMonth(), e.getDate().getMonth()),
                            Collectors.summingDouble(Expense::getExpense)));

            stringDoubleMap = new TreeMap<>(mapByCategories);
        }

        Double sumExpenses = periodExpensesList.stream()
                .mapToDouble(Expense::getExpense)
                .sum();

        List<Income> periodIncomesList = new ArrayList<>();

        if (incomeDao.findByIncomeByPeriod(user, minDatePeriod, maxDatePeriod).isPresent()) {
            periodIncomesList = (List<Income>) incomeDao.findByIncomeByPeriod(user, minDatePeriod, maxDatePeriod).get();
            logger.debug("Incomes period list is set as: {}", periodIncomesList);
        }

        Double sumIncomes = periodIncomesList.stream()
                .mapToDouble(Income::getIncome)
                .sum();

        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("maps", stringDoubleMap.entrySet());
        dataModel.put("sumExpenses", sumExpenses);
        dataModel.put("sumIncomes", sumIncomes);

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.warn("Template Exceptions {}", e.getMessage());
        }
    }
}
