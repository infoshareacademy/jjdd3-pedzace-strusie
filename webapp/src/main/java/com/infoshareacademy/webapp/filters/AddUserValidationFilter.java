package com.infoshareacademy.webapp.filters;

import com.infoshareacademy.webapp.messages.UserOperationsMessages;
import com.infoshareacademy.webapp.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(
        filterName = "AddUserValidationFilter",
        urlPatterns = {"/add-user"}
)
public class AddUserValidationFilter implements Filter {

    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        boolean isValidationOK = true;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        User user = getUserObject(httpRequest);
        List<String> messages = new ArrayList<>();

        String idParameter = httpRequest.getParameter("id");
//        String ageParameter = httpRequest.getParameter("age");

        if (!isIntegerParameterValid("id", httpRequest)) {
            messages.add(UserOperationsMessages.ID_NOT_INTEGER);
            isValidationOK = false;
        } else if (idParameter != null && !idParameter.isEmpty()) {
            user.setId(Long.parseLong(idParameter));
        }

//        if (!isIntegerParameterValid("age", httpRequest)) {
//            messages.add(UserOperationsMessages.AGE_NOT_INTEGER);
//            isValidationOK = false;
//        } else if (ageParameter != null && !ageParameter.isEmpty()) {
//            user.setAge(Integer.parseInt(httpRequest.getParameter("age")));
//        }

        if (!isValidationOK) {
            httpRequest.getSession().setAttribute("errors", messages);
            httpRequest.getSession().setAttribute("user", user);
            httpResponse.sendRedirect(httpRequest.getRequestURL().toString());
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private User getUserObject(HttpServletRequest servletRequest) {
        User user = new User();
        user.setId(null);
        user.setName(servletRequest.getParameter("name"));
        user.setLogin(servletRequest.getParameter("login"));
        user.setPassword(servletRequest.getParameter("password"));
//        user.setAge(null);
        return user;
    }

    private boolean isIntegerParameterValid(String parameterKey, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(parameterKey);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        logger.log(Level.INFO, String.valueOf(isPost));

        if (parameter == null || parameter.isEmpty()) {
            return !isPost;
        }

        Pattern integerPattern = Pattern.compile("\\d+");
        Matcher matcher = integerPattern.matcher(parameter);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

    @Override
    public void destroy() {

    }
}
