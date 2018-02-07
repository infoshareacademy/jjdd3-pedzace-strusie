package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public class MainMenu extends Menu{

    //main menu description
    private String[] mainMenuItems = {"Input your income", "Display current expenses", "Settings", "Exit"};

    public MainMenu() {
        chooseMenuItems(setMenuItems(mainMenuItems));
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

                if (idx < 1 || idx > mainMenuItems.length - 1) {
                    continue;
                }

                switch (idx) {
                    case 1: {
                        // menu input expenses
                        new IncomeMenu();
                        System.out.println(setMenuItems(mainMenuItems));
                        break;
                    }
                    case 2: {
                        // menu display current data
                        new ExpensesMenu();
                        System.out.println(setMenuItems(mainMenuItems));
                        break;
                    }
                    case 3:
                        // menu settings
                        new CategoryMenu();
                        System.out.println(setMenuItems(mainMenuItems));
                        break;
                }

            } catch (Exception e) {
                continue;
            }
        }
    }
}
