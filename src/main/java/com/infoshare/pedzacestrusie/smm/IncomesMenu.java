package com.infoshare.pedzacestrusie.smm;

public class IncomesMenu extends Menu {
    private String[] incomesMenuItems = {"income menu1", "income menu 2", "income menu 3", "Exit"};

    IncomesMenu() {
        printMenu(setMenuDescription(incomesMenuItems));
        readUserChoice(incomesMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                new InputService();
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(incomesMenuItems));
                break;
            }
            case 2: {
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(incomesMenuItems));
                break;
            }
            case 3: {
                System.out.println("Your choice is: " + idx);
                printMenu(setMenuDescription(incomesMenuItems));
                break;
            }
        }
    }
}
