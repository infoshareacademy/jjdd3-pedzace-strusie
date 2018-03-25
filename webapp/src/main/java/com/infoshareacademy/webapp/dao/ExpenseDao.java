package com.infoshareacademy.webapp.dao;


import model.Expense;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Local
public interface ExpenseDao {
    public Long save(Expense c);

    public Expense update(Expense c) ;

    public void delete(Long id) ;

    public Expense findById(Long id) ;

    public List<Expense> findAll() ;

    public Optional<Object> findByExpenseByPeriod(LocalDate minDatePeriod, LocalDate maxDatePeriod);

    }
