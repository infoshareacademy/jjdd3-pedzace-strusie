package com.infoshareacademy.webapp.dao;

import model.UserActiveCategory;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserActiveCategoryDao {
    public Long save(UserActiveCategory c);

    public UserActiveCategory update(UserActiveCategory c) ;

    public void delete(Long id) ;

    public UserActiveCategory findById(Long id) ;

    public List<UserActiveCategory> findAll() ;
}
