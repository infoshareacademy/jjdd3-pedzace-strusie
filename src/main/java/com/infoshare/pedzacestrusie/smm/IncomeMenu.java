package com.infoshare.pedzacestrusie.smm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public class IncomeMenu extends Menu {

    private String[] incomeMenuItems = {"income menu1", "income menu 2", "income menu 3", "Exit"};
    private int idx = 1;

    public IncomeMenu() {
        chooseMenuItems(getMenuItems(incomeMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);

        while (idx != 0) {
            try {
                idx = new Scanner(System.in).nextInt();
                if (idx < 1 || idx > incomeMenuItems.length - 1) {
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
                System.out.println("Your choice is: " + idx);
                new Income();
                break;
            }
            case 2: {
                System.out.println("Your choice is: " + idx);
                break;
            }
            case 3: {
                System.out.println("Your choice is: " + idx);
                break;
            }
        }
    }
}
