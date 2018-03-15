package com.infoshareacademy.webapp.dao_lockal;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDaoBeanLoc implements UserDaoLoc {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(User c) {
        entityManager.persist(c);
        return c.getId();
    }

    @Override
    public User update(User c) {
        return entityManager.merge(c);
    }

    @Override
    public void delete(Long id) {
        final User c = entityManager.find(User.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM User s");

        return query.getResultList();
    }
}
