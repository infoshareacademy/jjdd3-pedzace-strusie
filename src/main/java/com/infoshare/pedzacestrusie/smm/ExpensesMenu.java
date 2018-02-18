package com.infoshare.pedzacestrusie.smm;

public class ExpensesMenu extends Menu {

    private String[] expensesMenuItems = {"Sum expenses by date", "Sum expenses by categories", "Sum expenses by months", "Exit"};
    private int idx = 1;

    public ExpensesMenu() {
        chooseMenuItems(getMenuItems(expensesMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);
        readInputFromUser(expensesMenuItems.length);

    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                System.out.println("Ania: " + idx);
                break;
            }
            case 2: {
                System.out.println("Ania: " + idx);
                break;
            }
            case 3: {
                System.out.println("Ania: " + idx);
                break;
            }
        }
    }
}
