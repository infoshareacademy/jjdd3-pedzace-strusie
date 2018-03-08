package com.infoshareacademy.webapp.dao;

import com.infoshareacademy.webapp.domain.Category;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryDao {
    public Long save(Category c);

    public Category update(Category c) ;

    public void delete(Long id) ;

    public Category findById(Long id) ;

    public List<Category> findAll() ;
}
