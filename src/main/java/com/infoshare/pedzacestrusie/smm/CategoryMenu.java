package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public class CategoryMenu extends Menu {

    //main menu description
    private String[] categoryMenuItems = {"addCategory();", "showCategories();", "removeCategory();", "restoreDefault();", "Exit"};

    public CategoryMenu() {
        chooseMenuItems(setMenuItems(categoryMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {

        int idx = 1;

        //displays menu items
        System.out.println(menuDescr);

        //selects items from menu
        while (idx != 0) {
            try {

                idx = new Scanner(System.in).nextInt();

                if (idx < 1 || idx > categoryMenuItems.length - 1) {
                    continue;
                }

                switch (idx) {
                    case 1: {
                        //addCategory
                        System.out.println("Your choice is: " + idx);
                        break;
                    }
                    case 2: {
                        //showCategories
                        System.out.println("Your choice is: " + idx);
                        break;
                    }
                    case 3:
                        //removeCategory
                        System.out.println("Your choice is: " + idx);
                        break;
                    case 4:
                        //restoreDefault
                        System.out.println("Your choice is: " + idx);
                        break;
                }

            } catch (Exception e) {
                continue;
            }
        }
    }
}
