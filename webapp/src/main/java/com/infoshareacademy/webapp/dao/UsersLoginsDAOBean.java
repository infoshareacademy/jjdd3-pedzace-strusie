package com.infoshareacademy.webapp.dao;

import model.User;
import model.UsersLogins;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UsersLoginsDAOBean implements UsersLoginsDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(UsersLogins ul) {
        entityManager.persist(ul);
    }

    @Override
    public List<User> findAllUsersLogins() {
        final Query query = entityManager.createQuery("SELECT s FROM UsersLogins s");
        return query.getResultList();
    }
}
