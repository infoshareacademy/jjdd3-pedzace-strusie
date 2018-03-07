package com.infoshareacademy.webapp.repository;

import com.infoshareacademy.webapp.domain.Gender;
import com.infoshareacademy.webapp.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    private static List<User> usersRepository = new ArrayList<>();

    public static List<User> getRepository() {
        if (usersRepository.size() == 0) {
            fillRepositoryWithDefaults();
        }
        return usersRepository;
    }

    private static void fillRepositoryWithDefaults() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Jan");
        user1.setLogin("janko");
        user1.setAge(21);
        user1.setGender(Gender.MAN);
        usersRepository.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("Adam");
        user2.setLogin("ano");
        user2.setAge(20);
        user2.setGender(Gender.MAN);
        usersRepository.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("Anna");
        user3.setLogin("anmi");
        user3.setAge(20);
        user3.setGender(Gender.WOMAN);
        usersRepository.add(user3);
    }

    public static boolean contains(User user) {
        List<User> repository = getRepository();
        for (User userFromList : repository) {
            if (userFromList.getId() == user.getId()) {
                return true;
            }
        }
        return false;
    }
}
