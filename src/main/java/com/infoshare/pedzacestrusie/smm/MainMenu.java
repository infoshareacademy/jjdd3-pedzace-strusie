package com.infoshare.pedzacestrusie.smm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public class MainMenu extends Menu {

    private String[] mainMenuItems = {"Input your income", "Display current expenses", "Settings", "Exit"};
    private int idx = 1;

    public MainMenu() {
        chooseMenuItems(getMenuItems(mainMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);

        while (idx != 0) {
            try {
                idx = new Scanner(System.in).nextInt();
                if (idx < 1 || idx > mainMenuItems.length - 1) {
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
                new IncomeMenu();
                System.out.println(getMenuItems(mainMenuItems));
                break;
            }
            case 2: {
                new ExpensesMenu();
                System.out.println(getMenuItems(mainMenuItems));
                break;
            }
            case 3:
                new CategoryMenu();
                System.out.println(getMenuItems(mainMenuItems));
                break;
        }
    }
}