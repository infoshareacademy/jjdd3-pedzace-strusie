package com.infoshare.pedzacestrusie.smm;

public class StatisticsMenu extends Menu {
    private String[] statisticsMenuItems = {"Sum expenses by date", "Sum expenses by categories", "Sum expenses by months", "Exit"};

    StatisticsMenu() {
        printMenu(setMenuDescription(statisticsMenuItems));
        readUserChoice(statisticsMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                System.out.println("Ania: " + idx);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
            case 2: {
                System.out.println("Ania: " + idx);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
            case 3: {
                System.out.println("Ania: " + idx);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
        }
    }
}
