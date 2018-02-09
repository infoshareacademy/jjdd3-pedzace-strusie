package com.infoshare.pedzacestrusie.smm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Author: Maciej Wanagos
 */
public class ExpensesMenu extends Menu{

    private String[] expensesMenuItems = {"Sum expenses by date", "Sum expenses by categories", "Sum expenses by months","Exit"};
    private int idx = 1;

    public ExpensesMenu() {
        chooseMenuItems(getMenuItems(expensesMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);

        while (idx != 0) {
            try {
                idx = new Scanner(System.in).nextInt();
                if (idx < 1 || idx > expensesMenuItems.length - 1) {
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
                System.out.println("Ania: " + idx);
                break;
            }
            case 2: {
                System.out.println("Ania: " + idx);
                break;
            }
            case 3:{
                System.out.println("Ania: " + idx);
                break;
            }
        }
    }
}
