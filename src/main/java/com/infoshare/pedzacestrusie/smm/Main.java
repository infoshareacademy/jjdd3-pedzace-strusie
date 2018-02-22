package com.infoshare.pedzacestrusie.smm;

import com.infoshare.pedzacestrusie.smm.create_read_write.CsvReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Settings().updateDefaults(args);
        new MainMenu().executeMenu();

//        new StatisticsService().amountByCategory(UserRepository.getExpensesUserRepository());

    }
}
