package com.infoshareacademy.webapp.dao_lockal;

import javax.ejb.Local;
import java.util.List;
import java.util.Set;

@Local
public interface CategoryDaoLoc {
    public void save(String newCategory);

    public void update() ;

    public void delete(String removeCategory) ;

//    public Category findById(Long id) ;

    public boolean contains(String name);

    public Set<String> findAll() ;
}
