package com.infoshareacademy.webapp.dao_lockal;

import com.infoshareacademy.webapp.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserDaoLoc {
    public Long save(User c);

    public User update(User c) ;

    public void delete(Long id) ;

    public User findById(Long id) ;

    public List<User> findAll() ;
}
