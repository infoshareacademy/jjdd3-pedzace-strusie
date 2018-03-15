package com.infoshareacademy.webapp.dao_lockal;

import model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserDaoLoc {
    Long save(User c);

    User update(User c);

    void delete(Long id);

    User findById(Long id);

    List<User> findAll();
}
