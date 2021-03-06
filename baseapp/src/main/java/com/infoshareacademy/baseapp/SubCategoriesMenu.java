package com.infoshareacademy.baseapp;

import java.util.*;

public class SubCategoriesMenu extends Menu {
    private Set<String> categorySet = UserRepository.getCategoriesUserRepository();
    private String[] subCategoryMenuItems = categorySet.toArray(new String[0]);

    private String category;

    @Override
    protected void executeMenu() {
        printMenu(setMenuDescription(subCategoryMenuItems));
        readUserChoice(subCategoryMenuItems.length);
    }

    public String getCategory() {
        this.executeMenu();
        return category;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    @Override
    protected String setMenuDescription(String[] menuItems) {
        StringBuilder menuDescr = new StringBuilder("Choose option:");

        for (int i = 0, j = 1; i < menuItems.length; i++) {
            menuDescr.append("\n").append(j++).append(" - ").append(menuItems[i]);
        }
        return menuDescr.toString();
    }

    @Override
    protected void readUserChoice(int menuLength) {
        while (true) {
            try {
                int idx = new Scanner(System.in).nextInt();
                if (idx < 1 || idx > menuLength) {
                    System.out.println(ALERT_MESSAGE);
                } else {
                    checkUserSelection(idx);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(ALERT_MESSAGE);
            }
        }
    }

    @Override
    protected void checkUserSelection(int idx) {
        this.setCategory(subCategoryMenuItems[idx - 1]);
    }
}
