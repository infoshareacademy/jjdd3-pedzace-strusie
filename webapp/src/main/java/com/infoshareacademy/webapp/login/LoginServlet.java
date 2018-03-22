package com.infoshareacademy.webapp.login;


import com.auth0.AuthenticationController;
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

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    private AuthenticationController authenticationController;
    private String domain;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        domain = config.getServletContext().getInitParameter("com.auth0.domain");
        try {
            authenticationController = AuthenticationControllerProvider.getInstance(config);
        } catch (UnsupportedEncodingException e) {
            throw new ServletException("Couldn't create the AuthenticationController instance. Check the configuration.", e);
        }
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        String redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/callback";

        logger.info("Redirect URI: {}", redirectUri);

        String authorizeUrl = authenticationController.buildAuthorizeUrl(req, redirectUri)
                .withAudience(String.format("https://%s/userinfo", domain))
                .build();
        res.sendRedirect(authorizeUrl);
    }

}
