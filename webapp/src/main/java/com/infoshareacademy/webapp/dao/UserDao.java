package com.infoshareacademy.webapp.dao;

import model.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface UserDao {
    public Long save(User c);

    public User update(User c);

    public void delete(Long id);

    public User findById(Long id);

    public Optional<User> findByUserId(String userId);

    public List<User> findAll();
}
