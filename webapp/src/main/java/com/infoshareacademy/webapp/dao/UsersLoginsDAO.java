package com.infoshareacademy.webapp.dao;

import model.User;
import model.UsersLogins;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersLoginsDAO {

    void save(UsersLogins usersLogins);

    List<User> findAllUsersLogins();
}

