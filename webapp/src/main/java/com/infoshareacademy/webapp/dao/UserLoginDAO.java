package com.infoshareacademy.webapp.dao;

import model.User;
import model.UserLogin;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserLoginDAO {

    void save(UserLogin userLogin);

    List<User> findAllUsersLogins();
}

