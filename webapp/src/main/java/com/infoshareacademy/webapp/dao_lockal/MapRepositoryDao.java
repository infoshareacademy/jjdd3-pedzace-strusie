package com.infoshareacademy.webapp.dao_lockal;

import com.infoshareacademy.webapp.model.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

@Local
public interface MapRepositoryDao {
    void addUser(User user);

    User getUserById(int id);

    User getUserByLogin(String login);

    Map<Double, String> getUsersMap();
}
