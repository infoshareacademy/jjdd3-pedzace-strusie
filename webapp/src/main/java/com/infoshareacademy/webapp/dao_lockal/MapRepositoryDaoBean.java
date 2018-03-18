package com.infoshareacademy.webapp.dao_lockal;

import com.infoshareacademy.webapp.interceptors.AddUserInterceptor;
import com.infoshareacademy.webapp.repository.UsersRepository;
import model.User;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class MapRepositoryDaoBean implements MapRepositoryDao {

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
//            if (user.getLogin().equals(login)) {
                return user;
//            }


        }
        return null;
    }

    @Override
    public Map<Double, String> getUsersMap() {

        Map<Double,String> hm = new HashMap<>();
        hm.put(3.0,"three");
        hm.put(1.0,"one");
        hm.put(4.0,"four");
        hm.put(2.0,"two");

        return hm;
    }

}
