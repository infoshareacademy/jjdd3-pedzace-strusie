package com.infoshare.pedzacestrusie.smm;

public class IncomesMenu extends Menu {

    private String[] incomesMenuItems = {"income menu1", "income menu 2", "income menu 3", "Exit"};
    private int idx = 1;

    public IncomesMenu() {
        chooseMenuItems(createMenuItems(incomesMenuItems));
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);
        readInputFromUser(incomesMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                new InputService();
                System.out.println(createMenuItems(incomesMenuItems));

                break;
            }
            case 2: {
                System.out.println("Your choice is: " + idx);
                break;
            }
            case 3: {
                System.out.println("Your choice is: " + idx);
                break;
            }
        }
    }
}
