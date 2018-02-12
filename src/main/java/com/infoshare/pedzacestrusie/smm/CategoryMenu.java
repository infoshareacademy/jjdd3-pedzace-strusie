package com.infoshare.pedzacestrusie.smm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public class CategoryMenu extends Menu {

    private String[] categoryMenuItems = {"addCategory();", "showCategories();", "removeCategory();", "restoreDefault();", "Exit"};
    private int idx = 1;

    public CategoryMenu() {
        chooseMenuItems(getMenuItems(categoryMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);

        while (idx != 0) {
            try {
                idx = new Scanner(System.in).nextInt();
                if (idx < 1 || idx > categoryMenuItems.length - 1) {
                    continue;
                }
                checkUserSelection();
            } catch (InputMismatchException e) {
                continue;
            }
        }
    }

    @Override
    protected void checkUserSelection() {
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
