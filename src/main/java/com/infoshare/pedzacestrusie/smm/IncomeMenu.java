package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public class IncomeMenu extends Menu{

    //main menu description
    private String[] incomeMenuItems = {"income menu1", "income menu 2", "income menu 3","Exit"};

    public IncomeMenu() {
        chooseMenuItems(setMenuItems(incomeMenuItems));
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

                if (idx < 1 || idx > incomeMenuItems.length - 1) {
                    continue;
                }

                switch (idx) {
                    case 1: {
                        //income1
                        new IncomeMenu();
                        System.out.println("Your choice is: " + idx);
                        break;
                    }
                    case 2: {
                        //income2
                        System.out.println("Your choice is: " + idx);
                        break;
                    }
                    case 3:
                        //income3
                        System.out.println("Your choice is: " + idx);
                        break;
                }

            } catch (Exception e) {
                continue;
            }
        }


    }

}
