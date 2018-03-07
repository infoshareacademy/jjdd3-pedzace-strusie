package com.infoshareacademy.webapp.dao;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UsersRepositoryDaoRemote {
    List<String> getUsersNames();
}
