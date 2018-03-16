package com.infoshareacademy.webapp.filters;

import model.Income;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "AddIncomeFilter", urlPatterns = {"/add-income"})
public class AddIncomeFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AddIncomeFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        boolean isValidationOK = true;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        if (isPost) {
            Income income = new Income();
            List<String> messages = new ArrayList<>();

            String dateParameter = httpRequest.getParameter("date");
            String valueOfIncome = httpRequest.getParameter("income");

            if (!isDateParameterValid("date", httpRequest)) {
                messages.add("Date is out of bound. Please choose date again.");
                isValidationOK = false;
            } else if (dateParameter != null && !dateParameter.isEmpty()) {
                income.setDate(LocalDate.parse(dateParameter));
            }

            if (isValueOfExpenseValid("income", httpRequest)) {
                messages.add("Value of income is in invalid format. Please enter for example 2100.35");
                isValidationOK = false;
            } else if (valueOfIncome != null && !valueOfIncome.isEmpty()) {
                income.setIncome(Double.parseDouble(valueOfIncome));
            }

            if (!isValidationOK) {
                httpRequest.getSession().setAttribute("errors", messages);
                httpRequest.getSession().setAttribute("income", income);
                httpResponse.sendRedirect(httpRequest.getRequestURL().toString());
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    private boolean isDateParameterValid(String date, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(date);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        logger.error(String.valueOf(isPost));

        if (parameter == null || parameter.isEmpty()) {
            return !isPost;
        }

        Pattern datePattern = Pattern.compile("\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])*");
        Matcher matcher = datePattern.matcher(parameter);

        return matcher.matches();

    }

    private boolean isValueOfExpenseValid(String income, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(income);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        logger.error(String.valueOf(isPost));

        if (parameter.isEmpty() && parameter == null) {
            return !isPost;
        }

        Pattern expenseValuePattern = Pattern.compile("([0-9]{1,5}\\.){1}[0-9]{1,2}");
        Matcher matcher = expenseValuePattern.matcher(parameter);

        return !matcher.matches();
    }

    @Override
    public void destroy() {

    }
}
