package com.infoshare.pedzacestrusie.smm;

import com.infoshare.pedzacestrusie.smm.create_read_write.CsvWriter;

import java.util.Scanner;
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
        String categoryToRemove = inputService.getCategory();
        System.out.println("Category to remove is: \t" + categoryToRemove);
        checkCategoryToRemove(categoryToRemove);
    }

    protected void restoreDefaultCategories() {
        new Settings().updateCategorySetFromFile(UserRepository.getDefaultCategoriesFilePath());
        new CsvWriter().writeToCategoriesCsvFile(UserRepository.getCategoriesUserRepository(), UserRepository.getUserCategoriesFilePath());
    }

    private void checkCategoryToRemove(String categoryToRemove) {
        String categoryToRemoveFromUI = "";
        while (!isExit(categoryToRemoveFromUI)) {
            try {
                categoryToRemoveFromUI = this.readCategoryToRemoveFromUI();
                if (categoryToRemove.equals(categoryToRemoveFromUI)) {
                    categorySet.remove(categoryToRemove);
                    new CsvWriter().writeToCategoriesCsvFile(categorySet, UserRepository.getUserCategoriesFilePath());
                    System.out.printf("Category %s was deleted.", categoryToRemove.toUpperCase());
                    break;
                }
            } catch (Exception exc) {
                System.out.println(Menu.ALERT_MESSAGE);
            }
        }
    }

    private boolean isExit(String categoryToRemoveFromUI) {
        return categoryToRemoveFromUI.equals("0");
    }

    private String readCategoryToRemoveFromUI() {
        System.out.println("Please type in the name of the category to confirm or 0 to Exit.");
        return new Scanner(System.in).next().toLowerCase();
    }
}
