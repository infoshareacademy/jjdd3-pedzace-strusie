package com.infoshareacademy.webapp.dao;


import model.Category;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class CategoryDaoBean implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(Category c) {
        entityManager.persist(c);
        return c.getId();
    }

    @Override
    public Category update(Category c) {
        return entityManager.merge(c);
    }


    @Override
    public void restoreByUser(User user) {
        List<Category> names = entityManager.createQuery("UPDATE Category c SET c.isActive = 'false' WHERE c.user =:user")
                .setParameter("user", user).getResultList();
        entityManager.createQuery("UPDATE Category c SET c.isActive = 'true' WHERE c.user =:user and c.isDefault = 'true'")
                .setParameter("user", user).getResultList();
    }

    @Override
    public void delete(Long id) {
        final Category c = entityManager.find(Category.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    @Override
    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Category s");

        return query.getResultList();
    }


    @Override
    public Optional<Object> findAllByUser(User user) {
        try {
            List<Category> names = entityManager.createQuery("SELECT c FROM Category c WHERE c.user =:user and c.isActive=true ")
                    .setParameter("user", user).getResultList();
            if (names.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(names);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Category> findByCategoryName(User user, String name) {
        try {
            List<Category> names = entityManager.createQuery("SELECT c FROM Category c WHERE c.category = :categoryName and c.user =:user")
                    .setParameter("user", user).setParameter("categoryName", name).getResultList();
            if (names.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(names.get(0));
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
