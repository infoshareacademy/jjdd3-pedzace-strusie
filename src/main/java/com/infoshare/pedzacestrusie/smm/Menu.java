package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public abstract class Menu {


    //main menu description
    private String[] menuItems;

    /**
     * Sets menu items
     *
     * @return String menu description
     */
    protected String setMenuItems(String[] menuItems) {

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
    protected abstract void chooseMenuItems(String menuDescr);


}

