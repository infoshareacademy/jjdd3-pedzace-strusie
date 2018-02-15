package com.infoshare.pedzacestrusie.smm;

public class MainMenu extends Menu {

    private String[] mainMenuItems = {"Input your income", "Display current expenses", "Settings", "Exit"};
    private int idx = 1;

    public MainMenu() {
        chooseMenuItems(setMenuItems(mainMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);
        readInputFromUser(mainMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                new IncomesMenu();
                System.out.println(setMenuItems(mainMenuItems));
                break;
            }
            case 2: {
                new ExpensesMenu();
                System.out.println(setMenuItems(mainMenuItems));
                break;
            }
            case 3:
                new CategoriesMenu();
                System.out.println(setMenuItems(mainMenuItems));
                break;
        }
    }
}
