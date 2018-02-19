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
                new InputService().inputIncome();
                printMenu(setMenuDescription(budgetMenuItems));
                break;
            }
            case 2: {
                new InputService().inputExpense();
                printMenu(setMenuDescription(budgetMenuItems));
                break;
            }
        }
    }
}
