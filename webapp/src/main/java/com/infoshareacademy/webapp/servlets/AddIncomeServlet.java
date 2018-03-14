package com.infoshareacademy.webapp.servlets;


import com.infoshareacademy.baseapp.Income;
//import com.infoshareacademy.webapp.dao.IncomeDaoBean;
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

@WebServlet("/add-income")
public class AddIncomeServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(getClass().getName());

    private Template template;

    @EJB
    private IncomeDaoBean incomeDaoBean;


    @Override
    public void init() throws ServletException {

        try {
            template = TemplateProvider.createTemplate(getServletContext(), "incomes-service.ftlh");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Income income = new Income();
        income.setDate(LocalDate.parse(req.getParameter("date")));
        income.setIncome(Double.parseDouble(req.getParameter("income")));

//        incomeDaoBean.save(income);

        resp.sendRedirect("/"); //Należy wstawić odnośnik do servletu odpowiedzialnego za wyświetlenie listy
        // dochodów   !!!!!
    }
}
