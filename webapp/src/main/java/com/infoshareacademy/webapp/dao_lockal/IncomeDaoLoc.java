package com.infoshareacademy.webapp.dao_lockal;

import model.Income;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IncomeDaoLoc {
    public Long save(Income c);

    public Income update(Income c) ;

    public void delete(Long id) ;

    public Income findById(Long id) ;

    public List<Income> findAll() ;
}
