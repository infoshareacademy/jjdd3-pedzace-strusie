package com.infoshareacademy.webapp.dao;

import com.infoshareacademy.baseapp.Expense;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ExpenseDao {
    public Long save(Expense c);

    public Expense update(Expense c) ;

    public void delete(Long id) ;

    public Expense findById(Long id) ;

    public List<Expense> findAll() ;
}
