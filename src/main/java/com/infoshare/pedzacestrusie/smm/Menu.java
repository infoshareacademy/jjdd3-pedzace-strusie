package com.infoshare.pedzacestrusie.smm;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    private final static String ALERT_MESSAGE = "Incorrect choice. Please, try again!";
    private int idx = 1;

    protected String setMenuDescription(String[] menuItems) {
        String menuDescr = "Choose option:";

        for (int i = 0, j = 1; i < menuItems.length - 1; i++) {
            menuDescr += "\n" + j++ + " - " + menuItems[i];
        }
        return menuDescr += "\n0 - " + menuItems[menuItems.length - 1];
    }

    protected void printMenu(String menuDescr) {
        System.out.println(menuDescr);
    }

    protected void readUserChoice(int menuLength) {
        while (idx != 0) {
            try {
                idx = new Scanner(System.in).nextInt();
                if (idx < 0 || idx > menuLength - 1) {
                    System.out.println(ALERT_MESSAGE);
                    continue;
                }
                checkUserSelection(idx);
            } catch (InputMismatchException e) {
                System.out.println(ALERT_MESSAGE);
                continue;
            }
        }
    }

    protected abstract void checkUserSelection(int idx);
}

