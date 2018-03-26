package com.infoshareacademy.webapp.dao;

import model.User;
import model.UserLogin;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Stateless
public class UserService {

    @Inject
    private UserFactory userFactory;

    @Inject
    private UserLoginDAO userLoginDAO;

    public User initUserSession (String accessToken) {
        String userIdFromAuth = userFactory.getUserIdFromAuth(accessToken);
        User user = userFactory.createUser(userIdFromAuth);

        UserLogin userlogin = new UserLogin(user, LocalDateTime.now());
        userLoginDAO.save(userlogin);
        return user;
    }
}
