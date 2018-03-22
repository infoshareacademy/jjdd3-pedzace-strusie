package com.infoshareacademy.webapp.dao_lockal;

import com.infoshareacademy.webapp.interceptors.AddUserInterceptor;
import com.infoshareacademy.webapp.repository.UsersRepository;
import model.User;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao {

    @Override
    @Interceptors({AddUserInterceptor.class})
    public void addUser(User user) {
        UsersRepository.getRepository().add(user);
    }

    @Override
    public User getUserById(int id) {

        for (User user : UsersRepository.getRepository()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        for (User user : UsersRepository.getRepository()) {
                return user;
        }
        return null;
    }

    @Override
    public List<User> getUsersList() {

        return UsersRepository.getRepository();
    }

}
