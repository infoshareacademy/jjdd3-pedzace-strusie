package com.infoshareacademy.baseapp;

public class MainMenu extends Menu {
    private String[] mainMenuItems = {"Input your incomes and expenses", "Display statistics", "Settings", "Exit"};

    @Override
    protected void executeMenu() {
        printMenu(setMenuDescription(mainMenuItems));
        readUserChoice(mainMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                new BudgetMenu().executeMenu();
                new InputService().clearList();
                printMenu(setMenuDescription(mainMenuItems));
                break;
            }
            case 2: {
                new StatisticsMenu().executeMenu();
                new InputService().clearList();
                printMenu(setMenuDescription(mainMenuItems));
                break;
            }
            case 3:
                new CategoriesMenu().executeMenu();
                printMenu(setMenuDescription(mainMenuItems));
                break;
        }
    }
}
