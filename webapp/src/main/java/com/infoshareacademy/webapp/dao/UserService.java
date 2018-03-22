package com.infoshareacademy.webapp.dao;

import model.User;
import model.UsersLogins;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Stateless
public class UserService {

    @Inject
    UserFactory userFactory;

    @Inject
    UsersLoginsDAO usersLoginsDAO;

    public boolean initUserSession (String accessToken) {
        String userId = userFactory.getUserId(accessToken);
        User user = userFactory.createUser(userId, accessToken);
        UsersLogins userlogin = new UsersLogins(user, LocalDateTime.now());
        usersLoginsDAO.save(userlogin);
        boolean isAdmin = user.isAdmin();
        return isAdmin;
    }
}
