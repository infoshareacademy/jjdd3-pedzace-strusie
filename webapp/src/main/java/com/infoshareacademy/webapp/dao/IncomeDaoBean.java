package com.infoshareacademy.webapp.dao;

import model.Income;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Object> findByIncomeByPeriod(LocalDate minDatePeriod, LocalDate maxDatePeriod) {
        try {
            List<Income> names = entityManager.createQuery("SELECT i FROM Income i WHERE i.date BETWEEN :minDatePeriod and :maxDatePeriod")
                    .setParameter("minDatePeriod", minDatePeriod).setParameter("maxDatePeriod", maxDatePeriod).getResultList();
            if (names.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(names);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}