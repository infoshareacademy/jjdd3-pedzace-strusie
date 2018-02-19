package com.infoshare.pedzacestrusie.smm;

public class MainMenu extends Menu {
    private String[] mainMenuItems = {"Input your incomes and expenses", "Display statistics", "Settings", "Exit"};

    MainMenu() {
        printMenu(setMenuDescription(mainMenuItems));
        readUserChoice(mainMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                new BudgetMenu();
                printMenu(setMenuDescription(mainMenuItems));
                break;
            }
            case 2: {
                new StatisticsMenu();
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
