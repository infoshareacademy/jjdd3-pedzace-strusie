package com.infoshareacademy.webapp.dao;

import model.CategoryPromoted;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryPromotedDao {
    public Long save(CategoryPromoted c);

    public CategoryPromoted update(CategoryPromoted c) ;

    public void delete(Long id) ;

    public CategoryPromoted findById(Long id) ;

    public List<CategoryPromoted> findAll() ;
}
