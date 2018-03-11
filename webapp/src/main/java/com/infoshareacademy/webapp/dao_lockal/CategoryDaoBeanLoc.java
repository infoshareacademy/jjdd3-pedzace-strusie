package com.infoshareacademy.webapp.dao_lockal;

import com.infoshareacademy.baseapp.CsvWriter;
import com.infoshareacademy.baseapp.Settings;
import com.infoshareacademy.baseapp.UserRepository;
import com.infoshareacademy.webapp.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Stateless
public class CategoryDaoBeanLoc implements CategoryDaoLoc {
    //
//    @PersistenceContext
//    private EntityManager entityManager;
//


    @Override
    public void save(String newCategory) {
        new Settings().updateDefaults(new String[]{""});
        Set<String> categorySet = UserRepository.getCategoriesUserRepository();
        categorySet.add(newCategory);
        new CsvWriter().writeToCategoriesCsvFile(categorySet, UserRepository.getUserCategoriesFilePath());
    }
//
//    @Override
//    public Category update(Category c) {
//        return entityManager.merge(c);
//    }
//
//    @Override
//    public void delete(Long id) {
//        final Category c = entityManager.find(Category.class, id);
//        if (c != null) {
//            entityManager.remove(c);
//        }
//    }
//
//    @Override
//    public Category findById(Long id) {
//        return entityManager.find(Category.class, id);
//    }

    @Override
    public Set<String> findAll() {
        new Settings().updateDefaults(new String[]{""});
        return UserRepository.getCategoriesUserRepository();
    }
}
