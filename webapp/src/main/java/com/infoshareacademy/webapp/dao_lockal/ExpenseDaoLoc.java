package com.infoshareacademy.webapp.dao_lockal;

import model.Expense;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ExpenseDaoLoc {
    public Long save(Expense c);

    public Expense update(Expense c) ;

    public void delete(Long id) ;

    public Expense findById(Long id) ;

    public List<Expense> findAll() ;
}
