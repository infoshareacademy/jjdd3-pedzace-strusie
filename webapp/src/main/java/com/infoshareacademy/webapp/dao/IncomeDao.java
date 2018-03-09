package com.infoshareacademy.webapp.dao;

import com.infoshareacademy.baseapp.Income;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IncomeDao {
    public Long save(Income c);

    public Income update(Income c) ;

    public void delete(Long id) ;

    public Income findById(Long id) ;

    public List<Income> findAll() ;
}
