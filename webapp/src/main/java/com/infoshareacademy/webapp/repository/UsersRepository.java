package com.infoshareacademy.webapp.repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    private static List<User> usersRepository = new ArrayList<>();

    public static List<User> getUsersRepository() {
        return usersRepository;
    }

    public static void setUsersRepository(List<User> usersRepository) {
        UsersRepository.usersRepository = usersRepository;
    }

    public static List<User> getRepository() {
        if (usersRepository.size() == 0) {
            fillRepositoryWithDefaults();
        }
        return usersRepository;
    }

    private static void fillRepositoryWithDefaults() {
        User user1 = new User();
        user1.setId(1L);
//        user1.setName("Jan");
//        user1.setLogin("janko");
        usersRepository.add(user1);

        User user2 = new User();
        user2.setId(2L);
//        user2.setName("Adam");
//        user2.setLogin("ano");
        usersRepository.add(user2);

        User user3 = new User();
        user3.setId(3L);
//        user3.setName("Anna");
//        user3.setLogin("anmi");
        usersRepository.add(user3);
    }


}
