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

@WebServlet("/budget/add-income")
public class AddIncomeServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private Template template;

    @EJB
    private IncomeDao incomeDao;

    @Override
    public void init() throws ServletException {

        try {
            template = TemplateProvider.createTemplate(getServletContext(), "add-income.ftlh");
        } catch (IOException e) {
            logger.error("Template add-income is not found {}", e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");
        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            logger.info("Put errors into data model");

            req.getSession().removeAttribute("errors");
            req.getSession().removeAttribute("income");
        }

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error(e.getMessage(), e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Income income = new Income();
        income.setDate(LocalDate.parse(req.getParameter("date")));
        income.setIncome(Double.parseDouble(req.getParameter("income")));
        income.setUser((User) req.getSession().getAttribute("user"));
        logger.debug("Income date is set as: {}", income.getDate());
        logger.debug("Income value is set as: {}", income.getIncome());
        logger.debug("Income user is set as: {}", income.getUser());
        logger.debug("User ID is set as: {}", income.getUser().getId());

        incomeDao.save(income);

        resp.sendRedirect("/budget/start");

    }
}
