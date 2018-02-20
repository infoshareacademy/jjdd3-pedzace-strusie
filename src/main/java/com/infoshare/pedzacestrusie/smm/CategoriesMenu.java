package com.infoshare.pedzacestrusie.smm;

public class CategoriesMenu extends Menu {
    private String[] categoryMenuItems = {"addCategory();", "showCategories();", "removeCategory();", "restoreDefault();", "Exit"};

    @Override
    protected void executeMenu() {
        printMenu(setMenuDescription(categoryMenuItems));
        readUserChoice(categoryMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
            case 2: {
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
            case 3: {
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
            case 4: {
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(categoryMenuItems));
                break;
            }
        }
    }
}
