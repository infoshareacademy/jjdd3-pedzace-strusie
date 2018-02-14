package com.infoshare.pedzacestrusie.smm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubCategoriesMenu extends Menu{

    private String[] subCategoryMenuItems = {"cat01", "cat02", "cat03", "cat04", "Exit"};
    private int idx = 1;
    private String categories;

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public SubCategoriesMenu() {
        chooseMenuItems(getMenuItems(subCategoryMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);
        readInputFromUser(subCategoryMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        this.setCategories(subCategoryMenuItems[idx+1]);
    }

//    protected String chooseSubMenuItems(String menuDescr) {
//        System.out.println(menuDescr);
//
//        while (idx != 0) {
//            try {
//                idx = new Scanner(System.in).nextInt();
//                if (idx < 1 || idx > subCategoryMenuItems.length - 1) {
//                    continue;
//                }
//            } catch (InputMismatchException e) {
//                continue;
//            }
//        }
//        return subCategoryMenuItems[idx+1];
//    }
}
