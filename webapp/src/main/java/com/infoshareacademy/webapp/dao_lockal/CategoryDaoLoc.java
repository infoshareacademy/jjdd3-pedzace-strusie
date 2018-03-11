package com.infoshareacademy.webapp.dao_lockal;

import com.infoshareacademy.webapp.model.Category;

import javax.ejb.Local;
import java.util.List;
import java.util.Set;

@Local
public interface CategoryDaoLoc {
/*    public Long save(Category c);

    public Category update(Category c) ;

    public void delete(Long id) ;

    public Category findById(Long id) ;*/

    public Set<String> findAll() ;
}
