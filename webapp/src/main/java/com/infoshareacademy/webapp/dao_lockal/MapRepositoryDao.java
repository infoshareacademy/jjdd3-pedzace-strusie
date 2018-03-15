package com.infoshareacademy.webapp.dao_lockal;

import model.User;

import javax.ejb.Local;
import java.util.Map;

@Local
public interface MapRepositoryDao {
    void addUser(User user);

    User getUserById(int id);

    User getUserByLogin(String login);

    Map<Double, String> getUsersMap();
}
