package com.infoshare.pedzacestrusie.smm;

import com.infoshare.pedzacestrusie.smm.create_read_write.CsvWriter;

import java.util.Set;

public class CategoriesService {
    private Set<String> categorySet = UserRepository.getCategoriesUserRepository();
    private String[] categoryMenuItems = categorySet.toArray(new String[0]);

    protected void showCategories() {
        printCategoies(categoryMenuItems);
    }

    private void printCategoies(String[] menuItems) {
        StringBuilder menuDescr = new StringBuilder("Categories list:");

        for (int i = 0, j = 1; i < menuItems.length; i++) {
            menuDescr.append("\n").append(j++).append(" - ").append(menuItems[i]);
        }
        System.out.println(menuDescr);
    }

    protected void removeCategories() {
        InputService inputService = new InputService();
        inputService.readUserCategory();
        System.out.println("Removing: \t" + inputService.getCategories());
//TODO:potwierdzenie remove;
        categorySet.remove(inputService.getCategories());
        new CsvWriter().writeToCategoriesCsvFile(categorySet,UserRepository.getUserCategoriesFilePath());
    }

    protected void restoreDefaultCategoies(){
        new Settings().updateCategorySetFromFile(UserRepository.getDefaultCategoriesFilePath());
        new CsvWriter().writeToCategoriesCsvFile(UserRepository.getCategoriesUserRepository(), UserRepository.getUserCategoriesFilePath());
    }

    private boolean isRemovingCategoryOk(){
        return true;

    }
}
