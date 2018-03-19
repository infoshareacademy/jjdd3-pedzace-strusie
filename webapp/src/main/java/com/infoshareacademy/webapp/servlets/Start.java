package com.infoshareacademy.webapp.servlets;

import com.auth0.SessionUtils;
import com.infoshareacademy.webapp.dao.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet("/budget/start")
@MultipartConfig
public class Start extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String accessToken = (String) SessionUtils.get(req, "accessToken");
        final String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken != null) {
            req.setAttribute("userId", accessToken);
        } else if (idToken != null) {
            req.setAttribute("userId", idToken);
        } else {
            resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }

        boolean isAdmin = userService.initUserSession(accessToken);
        req.getSession().setAttribute("admin", isAdmin);
        logger.info("User AccessToken is: {}, user idToken is: {}", accessToken, idToken);
        logger.info("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQUser is admin: {}", isAdmin);



        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/home.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}