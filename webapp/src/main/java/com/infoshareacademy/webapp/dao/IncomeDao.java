package com.infoshareacademy.webapp.dao;

import com.infoshareacademy.baseapp.Income;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class IncomeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Income i) {
        entityManager.persist(i);
    }
}
