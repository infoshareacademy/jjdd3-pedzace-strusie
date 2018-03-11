package com.infoshareacademy.webapp.filters;

import com.infoshareacademy.webapp.dao_lockal.CategoryDaoLoc;
import com.infoshareacademy.webapp.messages.UserOperationsMessages;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(
        filterName = "RemoveCategoryValidationFilter",
        urlPatterns = {"/remove-category"}
)
public class RemoveCategoryValidationFilter implements Filter {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RemoveCategoryValidationFilter.class);

    @EJB
    CategoryDaoLoc categoryDaoLoc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        boolean isValidationOK = true;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String category = getCategoryObject(httpRequest);
        List<String> messages = new ArrayList<>();

        String categoryName = httpRequest.getParameter("name");

        if (!isStringParameterValid("name", httpRequest)) {
            messages.add(UserOperationsMessages.NAME_NOT_STRING);
            isValidationOK = false;
        } else if (categoryName != null && !categoryName.isEmpty()) {
            if (!categoryDaoLoc.contains(categoryName)) {
                messages.add(UserOperationsMessages.NAME_NOT_FOUND);
                isValidationOK = false;
            } else
                category = categoryName;
        }

        if (!isValidationOK) {
            httpRequest.getSession().setAttribute("errors", messages);
            httpRequest.getSession().setAttribute("category", category);
            httpResponse.sendRedirect(httpRequest.getRequestURL().toString());
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getCategoryObject(HttpServletRequest servletRequest) {
        return null;
    }

    private boolean isStringParameterValid(String parameterKey, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(parameterKey);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        logger.info(String.valueOf(isPost));

        if (parameter == null || parameter.isEmpty()) {
            return !isPost;
        }

        Pattern integerPattern = Pattern.compile("\\w+");
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
