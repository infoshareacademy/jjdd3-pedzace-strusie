package com.infoshareacademy.webapp.login;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(urlPatterns = {"/callback"})
public class CallbackServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    private String redirectOnSuccess;
    private String redirectOnFail;
    private AuthenticationController authenticationController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        redirectOnSuccess = getServletContext().getContextPath()+"/budget/start";
        redirectOnFail = getServletContext().getContextPath() + "/login";

        try {
            authenticationController = AuthenticationControllerProvider.getInstance(config);
        } catch (UnsupportedEncodingException e) {
            throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", e);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        handle(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        handle(req, res);
    }

    private void handle(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            Tokens tokens = authenticationController.handle(req);
            String accessToken = tokens.getAccessToken();
            String idToken = tokens.getIdToken();
            SessionUtils.set(req, "accessToken", accessToken);
            SessionUtils.set(req, "idToken", idToken);
            logger.info("authenticated as id={} accesToken={}", idToken, accessToken);
            res.sendRedirect(redirectOnSuccess);
        } catch (IdentityVerificationException e) {
            logger.error("Identity is not verify {}", e);
            res.sendRedirect(redirectOnFail);
        }
    }

}
