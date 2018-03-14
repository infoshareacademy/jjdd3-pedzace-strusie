package com.infoshareacademy.webapp.dao_lockal;

import model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersRepositoryDao {
    void addUser(User user);

    User getUserById(int id);

    User getUserByLogin(String login);

    List<User> getUsersList();
}
