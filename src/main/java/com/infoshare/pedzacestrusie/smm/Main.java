package com.infoshare.pedzacestrusie.smm;

import com.infoshare.pedzacestrusie.smm.create_read_write.CsvReader;
import com.sun.org.glassfish.external.statistics.Statistic;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Settings().update(args);
//        new MainMenu().executeMenu();

        CsvReader csvReader = new CsvReader();
        List<Expense> expenseList;

        expenseList = csvReader.readFromFileExpenses("Resources/testjanuary18exp.csv");
        System.out.println(expenseList);
        UserRepository.setExpensesUserRepository(expenseList);

new StatisticsService().amountAfterCategory(UserRepository.getExpensesUserRepository());

    }
}
