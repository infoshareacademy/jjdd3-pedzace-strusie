package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public class Menu {


    //main menu description
    private String[] menuItems = {"Input your data", "Display current data", "Settings", "Exit"};

    /**
     * Sets menu items
     *
     * @return String menu description
     */
    public String setMenuItems() {

        String menuDescr = "Choose option:";

        //adds lines to menu
        for (int i = 0, j = 1; i < menuItems.length - 1; i++) {
            menuDescr += "\n" + j++ + " - " + menuItems[i];
        }

        //adds last line 0-Exit
        menuDescr += "\n0 - " + menuItems[menuItems.length - 1];

        return menuDescr;
    }

    /**
     * Selects items form menu
     *
     * @param menuDescr String menu
     */
    private void chooseMenuItems(String menuDescr) {

        int idx = 1;

        //displays menu items
        System.out.println(menuDescr);

        //selects items from menu
        while (idx != 0) {
            try {

                idx = new Scanner(System.in).nextInt();

                if (idx < 1 || idx > menuItems.length - 1) {
                    continue;
                }

                switch (idx) {
                    case 1: {
                        // menu input expenses
                        System.out.println("Your choice is: " + idx);
                        System.out.println(new Income("2018-01-01", "CAT01", 215.545).getUserExpenses().get(0).getExpense());
                        break;
                    }
                    case 2: {
                        // menu display current data
                        System.out.println("Your choice is: " + idx);
                        System.out.println(new Income("2018-03-04", "CAT02", 356.45).getUserExpenses().get(0).getCategories());
                        break;
                    }
                    case 3:
                        // menu settings
                        System.out.println("Your choice is: " + idx);
                        System.out.println(new Income("2018-9-30", "CAT03", 3515.35).getUserExpenses().get(0).getDate());
                        break;
                }

            } catch (Exception e) {
                continue;
            }
        }
    }

    /**
     * Displays menu with menu description
     *
     * @param menuDescr String menu description
     */
    public void displayMenu(String menuDescr) {

        new Menu().chooseMenuItems(menuDescr);

    }
}

