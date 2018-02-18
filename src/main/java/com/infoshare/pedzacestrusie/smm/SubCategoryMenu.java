package com.infoshare.pedzacestrusie.smm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubCategoryMenu extends Menu{

    private String[] subCategoryMenuItems = {"cat01", "cat02", "cat03", "cat04", "Exit"};
    private int idx = 1;

    public SubCategoryMenu() {
        chooseMenuItems(getMenuItems(subCategoryMenuItems));
    }

    protected String chooseSubMenuItems(String menuDescr) {
        System.out.println(menuDescr);

        while (idx != 0) {
            try {
                idx = new Scanner(System.in).nextInt();
                if (idx < 1 || idx > subCategoryMenuItems.length - 1) {
                    continue;
                }
            } catch (InputMismatchException e) {
                continue;
            }
        }
        return subCategoryMenuItems[idx+1];
    }
}
