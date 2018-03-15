package com.infoshareacademy.webapp.dao;

import model.CategoryPromoted;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CategoryPromotedDaoBean implements CategoryPromotedDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(CategoryPromoted c) {
        entityManager.persist(c);
        return c.getId();
    }

    @Override
    public CategoryPromoted update(CategoryPromoted c) {
        return entityManager.merge(c);
    }

    @Override
    public void delete(Long id) {
        final CategoryPromoted c = entityManager.find(CategoryPromoted.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    @Override
    public CategoryPromoted findById(Long id) {
        return entityManager.find(CategoryPromoted.class, id);
    }

    @Override
    public List<CategoryPromoted> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM CategoryPromoted s");

        return query.getResultList();
    }
}
