package com.infoshareacademy.webapp.dao_lockal;

import javax.ejb.Local;
import java.util.Map;
import java.util.Set;

@Local
public interface StatisticsDaoLoc {
    public void save(String newCategory);

    public void update() ;

    public void delete(String removeCategory) ;

    public Map<String,Double> findExpensesByCategory() ;

    public Double findSumExpensesByCategory() ;

    public Double findSumIncomesByCategory() ;

    public boolean contains(String name);

    public Set<String> findAll() ;


}
