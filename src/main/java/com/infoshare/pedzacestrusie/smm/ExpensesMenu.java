package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public class ExpensesMenu extends Menu{

    //main menu description
    private String[] expensesMenuItems = {"Sum expenses by date", "Sum expenses by categories", "Sum expenses by months","Exit"};

    public ExpensesMenu() {
        chooseMenuItems(setMenuItems(expensesMenuItems));
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

                if (idx < 1 || idx > expensesMenuItems.length - 1) {
                    continue;
                }

                switch (idx) {
                    case 1: {
                        // menu input expenses
                        System.out.println("Ania: " + idx);
                        break;
                    }
                    case 2: {
                        // menu display current data
                        System.out.println("Ania: " + idx);
                        break;
                    }
                    case 3:
                        // menu settings
                        System.out.println("Ania: " + idx);
                        break;
                 }

            } catch (Exception e) {
                continue;
            }
        }
    }
}