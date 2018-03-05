package com.infoshareacademy.baseapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class Tester {
    private List<Expense> userExpense = UserRepository.getExpensesUserRepository();
    private List<Income> userIncome = UserRepository.getIncomesUserRepository();
    private Set<String> categorySet = UserRepository.getCategoriesUserRepository();
    private String[] categoryMenuItems = categorySet.toArray(new String[0]);

    private String date = "";
    private LocalDate localDate = LocalDate.now();

    private double expense;
    private double income;

    public void addTestExpensesDataToFile() {
        IntStream.range(0, 10).forEach(i -> {
            String year = String.valueOf(new Random().ints(1, 2015, 2018).findFirst().getAsInt());
            String month = String.valueOf(new Random().ints(1, 12, 13).findFirst().getAsInt());
            String day = String.valueOf(new Random().ints(1, 1, 28).findFirst().getAsInt());
            date = String.format("%s-%s-%s", year, month, day);
            localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-M-d"));
            int catNumber = new Random().ints(1, 0, categoryMenuItems.length).findFirst().getAsInt();
            String digit = String.valueOf(new Random().ints(1, 1, 1000).findFirst().getAsInt());
            String rest = String.valueOf(new Random().ints(1, 0, 99).findFirst().getAsInt());
            expense = Double.parseDouble(digit + "." + rest);
            userExpense.add(new Expense(localDate, categoryMenuItems[catNumber], expense));
        });
        new InputService().saveListToFile();
    }

    public void addTestIncomesDataToFile() {
        IntStream.range(0, 12).forEach(i -> {
            String year = String.valueOf(new Random().ints(1, 2017, 2018).findFirst().getAsInt());
            String month = String.valueOf(new Random().ints(1, 1 + i, 2 + i).findFirst().getAsInt());
            String day = String.valueOf(new Random().ints(1, 1, 28).findFirst().getAsInt());
            date = String.format("%s-%s-%s", year, month, day);
            localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-M-d"));
            String digit = String.valueOf(new Random().ints(1, 4000, 7000).findFirst().getAsInt());
            String rest = String.valueOf(new Random().ints(1, 0, 99).findFirst().getAsInt());
            income = Double.parseDouble(digit + "." + rest);
            userIncome.add(new Income(localDate, income));
        });
        new InputService().saveListToFile();
    }
}
