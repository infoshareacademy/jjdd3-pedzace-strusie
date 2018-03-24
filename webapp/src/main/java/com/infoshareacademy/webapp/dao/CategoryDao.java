package com.infoshareacademy.webapp.dao;


import model.Category;
import model.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface CategoryDao {
    public Long save(Category c);

    public Category update(Category c) ;

    public void delete(Long id) ;

    public Category findById(Long id) ;

    public List<Category> findAll() ;

    public Optional<Category> findByCategoryName(String name, User user);
}
