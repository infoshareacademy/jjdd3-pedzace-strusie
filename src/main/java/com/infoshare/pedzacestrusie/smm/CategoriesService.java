package com.infoshare.pedzacestrusie.smm;

import com.infoshare.pedzacestrusie.smm.create_read_write.CsvWriter;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class CategoriesService {
    private Set<String> categorySet = UserRepository.getCategoriesUserRepository();
    private String[] categoryMenuItems = categorySet.toArray(new String[0]);

    protected void showCategories() {
        printCategories(categoryMenuItems);
    }

    private void printCategories(String[] menuItems) {
        StringBuilder menuDescr = new StringBuilder("Categories list:");

        for (int i = 0, j = 1; i < menuItems.length; i++) {
            menuDescr.append("\n").append(j++).append(" - ").append(menuItems[i]);
        }
        System.out.println(menuDescr);
    }

    protected void addCategory() {
        String input = "";
        while (!isExit(input)) {
            try {
                input = this.addCategoryFromUI();
                if ((Pattern.matches("[A-Za-z0-9]+", input))) {
                    categorySet.add(input);
                    new CsvWriter().writeToCategoriesCsvFile(categorySet, UserRepository.getUserCategoriesFilePath());
                    System.out.printf("Category %s was added.%n", input.toUpperCase());
                    break;
                }
            } catch (Exception exc) {
                System.out.println(Menu.ALERT_MESSAGE);
            }
        }
    }

    private String addCategoryFromUI() {
        System.out.println("Please type in the name of the category to add or 0 to Exit.");
        return new Scanner(System.in).next().toLowerCase();
    }

    protected void removeCategory() {
        InputService inputService = new InputService();
        inputService.readUserCategory();
        String categoryToRemove = inputService.getCategory();
        System.out.println("Category to remove is: \t" + categoryToRemove);
        checkCategoryToRemove(categoryToRemove);
    }

    protected void restoreDefaultCategories() {
        new Settings().updateCategorySetFromFile(UserRepository.getDefaultCategoriesFilePath());
        new CsvWriter().writeToCategoriesCsvFile(UserRepository.getCategoriesUserRepository(), UserRepository.getUserCategoriesFilePath());
        System.out.println("Categories are up to date.");
    }

    private void checkCategoryToRemove(String categoryToRemove) {
        String categoryToRemoveFromUI = "";
        while (!isExit(categoryToRemoveFromUI)) {
            try {
                categoryToRemoveFromUI = this.readCategoryToRemoveFromUI();
                if (categoryToRemove.equals(categoryToRemoveFromUI)) {
                    categorySet.remove(categoryToRemove);
                    new CsvWriter().writeToCategoriesCsvFile(categorySet, UserRepository.getUserCategoriesFilePath());
                    System.out.printf("Category %s was deleted.%n", categoryToRemove.toUpperCase());
                    break;
                }
            } catch (Exception exc) {
                System.out.println(Menu.ALERT_MESSAGE);
            }
        }
    }

    private boolean isExit(String input) {
        return input.equals("0");
    }

    private String readCategoryToRemoveFromUI() {
        System.out.println("Please type in the name of the category to confirm or 0 to Exit.");
        return new Scanner(System.in).next().toLowerCase();
    }
}
