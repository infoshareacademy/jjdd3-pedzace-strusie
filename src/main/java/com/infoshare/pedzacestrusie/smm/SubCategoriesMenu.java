package com.infoshare.pedzacestrusie.smm;

import java.util.*;

public class SubCategoriesMenu extends Menu {
    private Set<String> categorySet = new TreeSet<>(Arrays.asList("Cat01", "Cat02", "Cat03"));
    private String[] subCategoryMenuItems = categorySet.toArray(new String[0]);

    private String categories;

    SubCategoriesMenu() {
        printMenu(setMenuDescription(subCategoryMenuItems));
        readUserChoice(subCategoryMenuItems.length);
    }

    public String getCategories() {
        return categories;
    }

    private void setCategories(String categories) {
        this.categories = categories;
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
//                    continue;
                } else {
                    checkUserSelection(idx);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(ALERT_MESSAGE);
//                continue;
            }
        }
    }

    @Override
    protected void checkUserSelection(int idx) {
        this.setCategories(subCategoryMenuItems[idx-1]);
    }
}