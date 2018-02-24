package com.infoshare.pedzacestrusie.smm;

public class CategoriesMenu extends Menu {
    private String[] categoryMenuItems = {"Show Categories", "addCategory();", "Remove Category", "Restore default categories", "Exit"};

    @Override
    protected void executeMenu() {
        printMenu(setMenuDescription(categoryMenuItems));
        readUserChoice(categoryMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                new CategoriesService().showCategories();
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
            case 2: {
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
            case 3: {
                new CategoriesService().removeCategories();
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
            case 4: {
                new CategoriesService().restoreDefaultCategoies();
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
        }
    }
}
