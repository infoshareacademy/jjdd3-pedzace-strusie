package com.infoshareacademy.webapp.dao;

import com.infoshareacademy.baseapp.Income;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class IncomeDaoBean implements IncomeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(Income c) {
        entityManager.persist(c);
        return c.getId();
    }

    @Override
    public Income update(Income c) {
        return entityManager.merge(c);
    }

    @Override
    public void delete(Long id) {
        final Income c = entityManager.find(Income.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    @Override
    public Income findById(Long id) {
        return entityManager.find(Income.class, id);
    }

    @Override
    public List<Income> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Income s");

        return query.getResultList();
    }
}
