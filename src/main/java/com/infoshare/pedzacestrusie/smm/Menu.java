package com.infoshare.pedzacestrusie.smm;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {

    private String[] menuItems;
    private int idx =1;

    protected String createMenuItems(String[] menuItems) {
        String menuDescr = "Choose option:";


        for (int i = 0, j = 1; i < menuItems.length - 1; i++) {
            menuDescr += "\n" + j++ + " - " + menuItems[i];
        }

//        menuDescr += "\n0 - " + menuItems[menuItems.length - 1];
        return menuDescr;
    }

    protected String addExitLineToMenuItems(String menuDescr){
//        this.createMenuItems(menuItems);
        return menuDescr += "\n0 - " + menuItems[menuItems.length - 1];
    }

    protected void readInputFromUser(int menuLength ){
        while (idx != 0) {
            try {
                idx = new Scanner(System.in).nextInt();
                if (idx < 1 || idx > menuLength - 1) {
                    continue;
                }
                checkUserSelection(idx);
            } catch (InputMismatchException e) {
                continue;
            }
        }

    }

    protected abstract void chooseMenuItems(String menuDescr);

    protected abstract void checkUserSelection(int idx);
}

