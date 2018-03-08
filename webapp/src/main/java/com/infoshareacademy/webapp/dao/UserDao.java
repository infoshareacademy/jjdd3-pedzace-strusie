package com.infoshareacademy.webapp.dao;

import com.infoshareacademy.webapp.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserDao {
    public Long save(User c);

    public User update(User c) ;

    public void delete(Long id) ;

    public User findById(Long id) ;

    public List<User> findAll() ;
}
