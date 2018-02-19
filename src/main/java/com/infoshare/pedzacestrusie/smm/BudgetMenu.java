package com.infoshare.pedzacestrusie.smm;

public class BudgetMenu extends Menu {
    private String[] budgetMenuItems = {"Input income", "Input expenses", "Exit"};

    BudgetMenu() {
        printMenu(setMenuDescription(budgetMenuItems));
        readUserChoice(budgetMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                new InputService();
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(budgetMenuItems));
                break;
            }
            case 2: {
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(budgetMenuItems));
                break;
            }

        }
    }
}
