package com.infoshare.pedzacestrusie.smm;

public class CategoriesMenu extends Menu {
    private String[] categoryMenuItems = {"Show Categories", "Add category", "Remove Category", "Restore default categories", "Exit"};

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
                new CategoriesService().addCategory();
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
            case 3: {
                new CategoriesService().removeCategory();
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
            case 4: {
                new CategoriesService().restoreDefaultCategories();
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
        }
    }
}
