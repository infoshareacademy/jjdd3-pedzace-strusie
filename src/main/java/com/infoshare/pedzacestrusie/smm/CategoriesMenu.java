package com.infoshare.pedzacestrusie.smm;

public class CategoriesMenu extends Menu {

    private String[] categoryMenuItems = {"addCategory();", "showCategories();", "removeCategory();", "restoreDefault();", "Exit"};
    private int idx = 1;

    public CategoriesMenu() {
        chooseMenuItems(setMenuItems(categoryMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);
        readInputFromUser(categoryMenuItems.length);

    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                System.out.println("Your choice is: " + idx);
                break;
            }
            case 2: {
                System.out.println("Your choice is: " + idx);
                break;
            }
            case 3: {
                System.out.println("Your choice is: " + idx);
                break;
            }
            case 4: {
                System.out.println("Your choice is: " + idx);
                break;
            }
        }
    }
}
