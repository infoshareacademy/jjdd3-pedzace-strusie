package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;

public class Menu {

    private String[] menuItems = {"Income", "Outcome", "Settings"};


    public String setMenuItems() {

        String menuDescr = "Choose option:";

        for (int i = 0, j = 1; i < menuItems.length; i++) {

            menuDescr += "\n" + j++ + " - " + menuItems[i];
        }
        return menuDescr;
    }

    public void chooseMenuItems(String menuDescr) {

        int idx;
        while (true) {
            try {

                idx = new Scanner(System.in).nextInt();

                if (idx < 1 || idx > menuItems.length) {
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


}

