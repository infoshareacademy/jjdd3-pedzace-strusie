package com.infoshare.pedzacestrusie.smm;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    protected final static String ALERT_MESSAGE = "Incorrect input data. Please, try again!";
    private int idx = 1;

    protected abstract void executeMenu();

    protected String setMenuDescription(String[] menuItems) {
        StringBuilder menuDescr = new StringBuilder("Choose option:");

        for (int i = 0, j = 1; i < menuItems.length - 1; i++) {
            menuDescr.append("\n").append(j++).append(" - ").append(menuItems[i]);
        }
        return menuDescr.append("\n0 - ").append(menuItems[menuItems.length - 1]).toString();
    }

    void printMenu(String menuDescr) {
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
            }
        }
    }

    protected abstract void checkUserSelection(int idx);
}

