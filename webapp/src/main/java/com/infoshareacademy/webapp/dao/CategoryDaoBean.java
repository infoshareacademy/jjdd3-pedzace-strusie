package com.infoshareacademy.webapp.dao;

import com.infoshareacademy.webapp.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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
}
