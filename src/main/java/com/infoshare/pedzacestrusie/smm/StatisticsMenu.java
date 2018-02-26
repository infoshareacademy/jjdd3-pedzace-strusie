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
                LocalDate minDatePeriod;
                LocalDate maxDatePeriod;

                while (true) {
                    System.out.println("Begin period:");
                    minDatePeriod = new InputService().getLocalDate();
                    System.out.println("End period:");
                    maxDatePeriod = new InputService().getLocalDate();

                    LocalDate tempDate = maxDatePeriod;
                    if (maxDatePeriod.isBefore(minDatePeriod)) {
                        maxDatePeriod = minDatePeriod;
                        minDatePeriod = tempDate;
                    }
                    if (!minDatePeriod.isEqual(maxDatePeriod)) {
                        break;
                    } else {
                        System.out.println("Date should be different!");
                    }
                }
                new StatisticsService().printAmountByCategoriesByPeriod(UserRepository.getExpensesUserRepository(), UserRepository.getIncomesUserRepository(), minDatePeriod, maxDatePeriod);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
            case 2: {
                new Settings().updateExpenseListFromFile();
                LocalDate minDatePeriod;
                LocalDate maxDatePeriod;

                while (true) {
                    System.out.println("Begin period:");
                    minDatePeriod = new InputService().getLocalDate();
                    System.out.println("End period:");
                    maxDatePeriod = new InputService().getLocalDate();

                    LocalDate tempDate = maxDatePeriod;
                    if (maxDatePeriod.isBefore(minDatePeriod)) {
                        maxDatePeriod = minDatePeriod;
                        minDatePeriod = tempDate;
                    }
                    if (!minDatePeriod.isEqual(maxDatePeriod)) {
                        break;
                    }else {
                        System.out.println("Date should be different!");
                    }
                }
                new StatisticsService().printAmountByDateByPeriod(UserRepository.getExpensesUserRepository(), minDatePeriod, maxDatePeriod);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
            case 3: {
                new Settings().updateExpenseListFromFile();
                LocalDate minDatePeriod;
                LocalDate maxDatePeriod;

                while (true) {
                    System.out.println("Begin period:");
                    minDatePeriod = new InputService().getLocalDate();
                    System.out.println("End period:");
                    maxDatePeriod = new InputService().getLocalDate();

                    LocalDate tempDate = maxDatePeriod;
                    if (maxDatePeriod.isBefore(minDatePeriod)) {
                        maxDatePeriod = minDatePeriod;
                        minDatePeriod = tempDate;
                    }
                    if (!minDatePeriod.isEqual(maxDatePeriod)) {
                        break;
                    }else {
                        System.out.println("Date should be different!");
                    }
                }
                new StatisticsService().printAmountByDateByCategoriesByPeriod(UserRepository.getExpensesUserRepository(), minDatePeriod, maxDatePeriod);
                printMenu(setMenuDescription(statisticsMenuItems));
                break;
            }
        }
    }
}
