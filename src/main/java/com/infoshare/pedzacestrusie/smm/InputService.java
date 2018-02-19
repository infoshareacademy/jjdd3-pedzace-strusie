package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.List;

public class InputService {

    private final static String DTF = "yyyy-MM-dd";
    private final static double MAX_VALUE_OF_EXPENSE = 1000000;
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DTF);

    private List<Expense> userExpense = new ArrayList<>();

    private String date = "";
    private LocalDate localDate = LocalDate.now();

    private String categories;
    private double expense;

    InputService() {
        this.readUserDate();
        this.readUserCategory();
        this.readUserExpense();
        this.setListExpenses();
    }

    private void readUserDate() {
        while (!isDataFormatIsOk()) {
            try {
                this.readDateFromUI();
                this.parseDateFromUI();
            } catch (DateTimeParseException exc) {
                System.out.println(Menu.ALERT_MESSAGE);
                date = "";
            }
        }
    }

    private boolean isDataFormatIsOk() {
        return localDate.toString().equals(date);
    }

    private void readDateFromUI() {
        System.out.println("Enter date[" + DTF.toUpperCase() + "]: ");
        date = new Scanner(System.in).next();
    }

    private void parseDateFromUI() {
        localDate = LocalDate.parse(date, FORMATTER);
    }

    private void readUserCategory() {
        categories = new SubCategoriesMenu().getCategories();
    }

    private void readUserExpense() {
        System.out.println("Input your expense: ");
        while (true) {
            try {
                expense = new Scanner(System.in).nextDouble();
                if (expense <= 0 || expense > MAX_VALUE_OF_EXPENSE) {
                    System.out.println(Menu.ALERT_MESSAGE);
//                    continue;
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(Menu.ALERT_MESSAGE);
//                continue;
            }
        }
    }

    private void setListExpenses() {
        System.out.println(localDate + "\t" + categories + "\t" + expense);
        userExpense.add(new Expense(localDate, categories, expense));
        userExpense.forEach(System.out::println);
    }

}
