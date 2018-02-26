package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;

public class StatisticsMenu extends Menu {
    private String[] statisticsMenuItems = {"Expenses by categories", "Expenses by months", "Expenses and categories by months", "Exit"};

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
                new Settings().updateIncomeListFromFile();

                System.out.println("Begin period:");
                LocalDate minDatePeriod = new InputService().getLocalDate();
                System.out.println("End period:");
                LocalDate maxDatePeriod = new InputService().getLocalDate();

                new StatisticsService().printAmountByCategoriesByPeriod(UserRepository.getExpensesUserRepository(), UserRepository.getIncomesUserRepository(), minDatePeriod, maxDatePeriod);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
            case 2: {
                new Settings().updateExpenseListFromFile();

                System.out.println("Begin period:");
                LocalDate minDatePeriod = new InputService().getLocalDate();
                System.out.println("End period:");
                LocalDate maxDatePeriod = new InputService().getLocalDate();

                new StatisticsService().printAmountByDateByPeriod(UserRepository.getExpensesUserRepository(), minDatePeriod, maxDatePeriod);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
            case 3: {
                new Settings().updateExpenseListFromFile();

                System.out.println("Begin period:");
                LocalDate minDatePeriod = new InputService().getLocalDate();
                System.out.println("End period:");
                LocalDate maxDatePeriod = new InputService().getLocalDate();

                new StatisticsService().printAmountByDateByCategoriesByPeriod(UserRepository.getExpensesUserRepository(), minDatePeriod, maxDatePeriod);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
        }
    }
}
