package com.infoshareacademy.webapp.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "AddExpenseFilter", urlPatterns = {"http://localhost:8080/budget/add-expense"})
public class AddExpenseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }


    /*private  static final Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        boolean isValidationOK = true;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        Expense expense = getExpenseObject(httpRequest);
        List<String> messages = new ArrayList<>();

        String dateParameter = httpRequest.getParameter("date");
        String valueOfExpense = httpRequest.getParameter("expense");

        if (!isDateParameterValid("date", httpRequest)) {
            messages.add("Your date is out of bound. Please choose date again.");
            isValidationOK = false;
        } else if (dateParameter != null && !dateParameter.isEmpty()) {
            expense.setDate(LocalDate.parse(dateParameter));
        }

        if (isValueOfExpenseValid("expense", httpRequest)) {
           messages.add("Your value of expnese is in invalid format. Please enter for example 450.35");
           isValidationOK = false;
        } else if (valueOfExpense != null || !valueOfExpense.isEmpty()){
            expense.setExpense(Double.parseDouble(valueOfExpense));
        }

        if (!isValidationOK){
            httpRequest.getSession().setAttribute("errors" , messages);
            httpRequest.getSession().setAttribute("expense", expense);
            httpResponse.sendRedirect(httpRequest.getRequestURL().toString());
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Expense getExpenseObject(HttpServletRequest servletRequest) {
        Expense expense = new Expense();
        expense.setDate(null);
        expense.setCategory(servletRequest.getParameter("category"));
        expense.setExpense(Double.parseDouble(null));

        return expense;
    }

    private boolean isDateParameterValid(String date, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(date);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        logger.log(Level.INFO, String.valueOf(isPost));

        if (parameter == null || parameter.isEmpty()) {
            return !isPost;
        }

        Pattern datePattern = Pattern.compile("\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])*");
        Matcher matcher = datePattern.matcher(parameter);

        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    private boolean isValueOfExpenseValid(String expense, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(expense);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        logger.log(Level.INFO, String.valueOf(isPost));

        if (parameter == null || parameter.isEmpty()) {
            return !isPost;
        }

        Pattern expenseValuePattern = Pattern.compile("([0-9]{1,5}\\.){1}[0-9]{1,2}");
        Matcher matcher = expenseValuePattern.matcher(parameter);

        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    @Override
    public void destroy() {

    }*/
}
