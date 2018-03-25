package com.infoshareacademy.webapp.dao;

import model.Income;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Local
public interface IncomeDao {
    public Long save(Income c);

    public Income update(Income c) ;

    public void delete(Long id) ;

    public Income findById(Long id) ;

    public List<Income> findAll() ;

    public Optional<Object> findByIncomeByPeriod(LocalDate minDatePeriod, LocalDate maxDatePeriod);

}
