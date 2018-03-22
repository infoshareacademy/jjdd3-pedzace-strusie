package com.infoshareacademy.webapp.dao;

import model.User;
import model.UsersLogins;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Stateless
public class UserService {

    @Inject
    private UserFactory userFactory;

    @Inject
    private UsersLoginsDAO usersLoginsDAO;

    public boolean initUserSession (String accessToken) {
        String userIdFromAuth = userFactory.getUserIdFromAuth(accessToken);
        User user = userFactory.createUser(userIdFromAuth);
        UsersLogins userlogin = new UsersLogins(user, LocalDateTime.now());
        usersLoginsDAO.save(userlogin);
        boolean isAdmin = user.isAdmin();
        return isAdmin;
    }
}
