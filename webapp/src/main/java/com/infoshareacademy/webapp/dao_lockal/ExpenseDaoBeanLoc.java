package com.infoshareacademy.webapp.dao_lockal;

import com.infoshareacademy.baseapp.Expense;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ExpenseDaoBeanLoc implements ExpenseDaoLoc {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(Expense c) {
        entityManager.persist(c);
        return c.getId();
    }

    @Override
    public Expense update(Expense c) {
        return entityManager.merge(c);
    }

    @Override
    public void delete(Long id) {
        final Expense c = entityManager.find(Expense.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    @Override
    public Expense findById(Long id) {
        return entityManager.find(Expense.class, id);
    }

    @Override
    public List<Expense> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Expense s");

        return query.getResultList();
    }
}
