package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;

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
    public void chooseMenuItems(String menuDescr) {

        int idx;

        //displays menu items
        System.out.println(menuDescr);

        //selects items from menu
        while (true) {
            try {

                idx = new Scanner(System.in).nextInt();

                if (idx == 0) {
                    break;
                }

                if (idx < 1 || idx > menuItems.length - 1) {
                    continue;
                }
                //do something
                System.out.println("Your choice is: " + idx);

            } catch (NullPointerException e) {
                break;
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

