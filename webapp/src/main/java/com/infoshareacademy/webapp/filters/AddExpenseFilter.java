package com.infoshareacademy.webapp.filters;

import com.infoshareacademy.baseapp.Expense;
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
import java.util.logging.Level;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "AddExpenseFilter", urlPatterns = {"/add-expense"})
public class AddExpenseFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AddExpenseFilter.class);

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
            Expense expense = new Expense();
            List<String> messages = new ArrayList<>();

            String dateParameter = httpRequest.getParameter("date");
            String valueOfExpense = httpRequest.getParameter("expense");

            if (!isDateParameterValid("date", httpRequest)) {
                messages.add("Your date is out of bound. Please choose date again.");
                isValidationOK = false;
            } else if (dateParameter != null && !dateParameter.isEmpty()) {
                // TODO; check date format
                expense.setDate(LocalDate.parse(dateParameter));
            }

            if (isValueOfExpenseValid("expense", httpRequest)) {
                messages.add("Your value of expense is in invalid format. Please enter for example 450.35");
                isValidationOK = false;
            } else if (valueOfExpense != null && !valueOfExpense.isEmpty()) {
                // TODO; check if valueOfExpense is valid double
                expense.setExpense(Double.parseDouble(valueOfExpense));
            }

            if (!isValidationOK) {
                httpRequest.getSession().setAttribute("errors", messages);
                httpRequest.getSession().setAttribute("expense", expense);
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

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isValueOfExpenseValid(String expense, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(expense);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        logger.error(String.valueOf(isPost));

        if (parameter == null || parameter.isEmpty()) {
            return !isPost;
        }

        Pattern expenseValuePattern = Pattern.compile("([0-9]{1,5}\\.){1}[0-9]{1,2}");
        Matcher matcher = expenseValuePattern.matcher(parameter);

        if (!matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void destroy() {

    }
}
