package com.infoshareacademy.webapp.dao;

import model.Expense;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Stateless
public class ExpenseDaoBean implements ExpenseDao{

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

    @Override
    public Optional<Object> findByExpenseByPeriod(User user, LocalDate minDatePeriod, LocalDate maxDatePeriod) {
        try {
            List<Expense> names = entityManager.createQuery("SELECT e FROM Expense e WHERE e.user =:user and e.date BETWEEN :minDatePeriod and :maxDatePeriod")
                    .setParameter("user", user).setParameter("minDatePeriod", minDatePeriod).setParameter("maxDatePeriod", maxDatePeriod).getResultList();
            if (names.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(names);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
