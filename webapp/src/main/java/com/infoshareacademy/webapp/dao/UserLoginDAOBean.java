package com.infoshareacademy.webapp.dao;

import model.User;
import model.UserLogin;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserLoginDAOBean implements UserLoginDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(UserLogin ul) {
        entityManager.persist(ul);
    }

    @Override
    public List<User> findAllUsersLogins() {
        final Query query = entityManager.createQuery("SELECT s FROM UserLogin s");
        return query.getResultList();
    }
}
