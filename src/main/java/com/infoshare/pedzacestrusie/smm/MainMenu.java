package com.infoshare.pedzacestrusie.smm;

public class MainMenu extends Menu {
    private String[] mainMenuItems = {"Input your income", "Display current expenses", "Settings", "Exit"};

    MainMenu() {
        printMenu(setMenuDescription(mainMenuItems));
        readUserChoice(mainMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                new IncomesMenu();
                printMenu(setMenuDescription(mainMenuItems));
                break;
            }
            case 2: {
                new ExpensesMenu();
                printMenu(setMenuDescription(mainMenuItems));
                break;
            }
            case 3:
                new CategoriesMenu();
                printMenu(setMenuDescription(mainMenuItems));
                break;
        }
    }
}
