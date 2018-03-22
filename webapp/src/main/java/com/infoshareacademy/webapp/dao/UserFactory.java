package com.infoshareacademy.webapp.dao;

import com.infoshareacademy.webapp.login.AuthClient;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

@Stateless
public class UserFactory {

    private final Logger logger = LogManager.getLogger(getClass().getName());
    private final String url = "https://pedzacestrusie.eu.auth0.com/userinfo";

    @Inject
    private UserDao userDAOBean;

    public User createUser(String userId, String accessToken) {

        Optional<User> user = userDAOBean.findByUserId(userId);
        if (user.isPresent()) {
            return user.get();
        }
        User newUser = new User(userId, false);
        userDAOBean.save(newUser);
        return newUser;
    }

    public String getUserId(String accessToken) {

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(url);
        AuthClient authClient = target.proxy(AuthClient.class);
        String userId = authClient.getUserInfo("Bearer " + accessToken);
        return userId;
    }

    public User addAdmin (String userId) {
        logger.info("Add new Admin");
        Optional<User> user = userDAOBean.findByUserId(userId);
        if (user.isPresent()) {
            return user.get();
        }
        logger.info("Create new Admin");
        User newUser = new User(userId, true);
        userDAOBean.save(newUser);
        return newUser;
    }
}
