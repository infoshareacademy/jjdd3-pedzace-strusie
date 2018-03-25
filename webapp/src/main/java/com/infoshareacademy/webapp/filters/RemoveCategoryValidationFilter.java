package com.infoshareacademy.webapp.filters;

import com.infoshareacademy.webapp.dao.CategoryDao;
import com.infoshareacademy.webapp.dao.UserDao;
import com.infoshareacademy.webapp.messages.UserOperationsMessages;
import model.Category;
import model.User;
import org.slf4j.Logger;
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

@WebFilter(filterName = "RemoveCategoryValidationFilter", urlPatterns = {"/remove-category"})
public class RemoveCategoryValidationFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    CategoryDao categoryDao;

    @EJB
    private UserDao userDao;

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
            List<String> messages = new ArrayList<>();

            Category removeCategory = new Category();
            String categoryParameter = httpRequest.getParameter("name").toLowerCase();
            User user = userDao.findById(((User) httpRequest.getSession().getAttribute("user")).getId());

            if (!isCategoryParameterValid("name", httpRequest)) {
                messages.add(UserOperationsMessages.NAME_NOT_FOUND);
                isValidationOK = false;
            } else if (categoryParameter != null && !categoryParameter.isEmpty()) {
                if (!categoryDao.findByCategoryName(user, categoryParameter).isPresent()) {
                    messages.add(UserOperationsMessages.NAME_NOT_FOUND);
                    isValidationOK = false;
                } else {
                    removeCategory.setCategory(categoryParameter);
                }
            }

            if (!isValidationOK) {
                httpRequest.getSession().setAttribute("errors", messages);
                httpRequest.getSession().setAttribute("removeCategory", removeCategory.getCategory());
                httpResponse.sendRedirect(httpRequest.getRequestURL().toString());
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isCategoryParameterValid(String name, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(name);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        logger.info(String.valueOf(isPost));

        if (parameter == null || parameter.isEmpty()) {
            return !isPost;
        }

        Pattern datePattern = Pattern.compile("\\w+");
        Matcher matcher = datePattern.matcher(parameter);

        return matcher.matches();
    }

    @Override
    public void destroy() {
    }
}
