package com.infoshare.pedzacestrusie.smm;

public class ExpensesMenu extends Menu {
    private String[] expensesMenuItems = {"Sum expenses by date", "Sum expenses by categories", "Sum expenses by months", "Exit"};

    ExpensesMenu() {
        printMenu(setMenuDescription(expensesMenuItems));
        readUserChoice(expensesMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                System.out.println("Ania: " + idx);
                printMenu(setMenuDescription(expensesMenuItems));
                break;
            }
            case 2: {
                System.out.println("Ania: " + idx);
                printMenu(setMenuDescription(expensesMenuItems));
                break;
            }
            case 3: {
                System.out.println("Ania: " + idx);
                printMenu(setMenuDescription(expensesMenuItems));
                break;
            }
        }
    }
}
