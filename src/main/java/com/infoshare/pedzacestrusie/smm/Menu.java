package com.infoshare.pedzacestrusie.smm;

public abstract class Menu {

    private String[] menuItems;

    protected String getMenuItems(String[] menuItems) {

        String menuDescr = "Choose option:";

        for (int i = 0, j = 1; i < menuItems.length - 1; i++) {
            menuDescr += "\n" + j++ + " - " + menuItems[i];
        }

        menuDescr += "\n0 - " + menuItems[menuItems.length - 1];
        return menuDescr;
    }
    protected abstract void chooseMenuItems(String menuDescr);
}

