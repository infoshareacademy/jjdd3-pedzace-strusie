package com.infoshareacademy.webapp.dao;

import model.UserActiveCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class UserActiveCategoryDaoBean implements UserActiveCategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(UserActiveCategory c) {
        entityManager.persist(c);
        return c.getId();
    }

    @Override
    public UserActiveCategory update(UserActiveCategory c) {
        return entityManager.merge(c);
    }

    @Override
    public void delete(Long id) {
        final UserActiveCategory c = entityManager.find(UserActiveCategory.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    @Override
    public UserActiveCategory findById(Long id) {
        return entityManager.find(UserActiveCategory.class, id);
    }

    @Override
    public List<UserActiveCategory> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM UserActiveCategory s");

        return query.getResultList();
    }
}
