package com.infoshareacademy.webapp.dao_lockal;

import com.infoshareacademy.baseapp.CategoriesService;
import com.infoshareacademy.baseapp.CsvWriter;
import com.infoshareacademy.baseapp.Settings;
import com.infoshareacademy.baseapp.UserRepository;

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

    @Override
    public void update() {
        new Settings().updateDefaults(new String[]{""});
//        new CategoriesService().restoreDefaultCategories();

        new Settings().updateCategorySetFromFile(UserRepository.getDefaultCategoriesFilePath());
        new CsvWriter().writeToCategoriesCsvFile(UserRepository.getCategoriesUserRepository(), UserRepository.getUserCategoriesFilePath());

    }

    @Override
    public void delete(String removeCategory) {
        new Settings().updateDefaults(new String[]{""});
        Set<String> categorySet = UserRepository.getCategoriesUserRepository();
        categorySet.remove(removeCategory);
        new CsvWriter().writeToCategoriesCsvFile(categorySet, UserRepository.getUserCategoriesFilePath());
    }

    //    @Override
//    public Category findById(Long id) {
//        return entityManager.find(Category.class, id);
//    }

    @Override
    public boolean contains(String name) {
        new Settings().updateDefaults(new String[]{""});
        Set<String> categorySet = UserRepository.getCategoriesUserRepository();
        for (String category : categorySet) {
            if (category.equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<String> findAll() {
        new Settings().updateDefaults(new String[]{""});
        return UserRepository.getCategoriesUserRepository();
    }
}
