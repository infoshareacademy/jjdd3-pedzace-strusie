package com.infoshare.pedzacestrusie.smm;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.time.LocalDate;

public class StatisticsMenu extends Menu {
    private String[] statisticsMenuItems = {"Sum expenses by categories", "Sum expenses by date", "Sum expenses by months", "Exit"};

    @Override
    protected void executeMenu() {
        printMenu(setMenuDescription(statisticsMenuItems));
        readUserChoice(statisticsMenuItems.length);
    }

    @Override
    protected void checkUserSelection(int idx) {
        switch (idx) {
            case 1: {
                new Settings().updateExpenseListFromFile();
                new StatisticsService().amountByCategory(UserRepository.getExpensesUserRepository());
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
            case 2: {
                new Settings().updateExpenseListFromFile();
                //for test only
                System.out.println("Begin period:");
                LocalDate minDatePeriod = new InputService().getLocalDate();
                System.out.println("End period:");
                LocalDate maxDatePeriod = new InputService().getLocalDate();
                new StatisticsService().amountByCategoryByPeriod(UserRepository.getExpensesUserRepository(),minDatePeriod,maxDatePeriod);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
            case 3: {
                new Settings().updateExpenseListFromFile();
                new StatisticsService().testAmountByCategory(UserRepository.getExpensesUserRepository());
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
        }
    }
}
