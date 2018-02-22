package com.infoshare.pedzacestrusie.smm;

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
                LocalDate minDatePeriod = LocalDate.parse("2050-01-01");
                LocalDate maxDatePeriod = LocalDate.parse("3000-02-01");
                new StatisticsService().amountByCategoryByPeriod(UserRepository.getExpensesUserRepository(),minDatePeriod,maxDatePeriod);
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
