package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class InputService {

    private final static String DTF = UserRepository.getDateTimeFormatter();
    private final static double MAX_VALUE_OF_EXPENSE = 1000000;
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DTF);

    private static List<Expense> userExpense = UserRepository.getExpenseUserRepository();
    private static List<Income> userIncome = UserRepository.getIncomeUserRepository();

    private String date = "";
    private LocalDate localDate = LocalDate.now();

    private String categories;
    private double expense;
    private double income;

    protected void inputExpense() {
        this.readUserDate();
        this.readUserCategory();
        this.readUserExpense();
        this.setExpensesList();
    }

    protected void inputIncome() {
        this.readUserDate();
        this.readUserIncome();
        this.setIncomesList();
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
        SubCategoriesMenu subCategoriesMenu = new SubCategoriesMenu();
        subCategoriesMenu.executeMenu();
        categories = subCategoriesMenu.getCategories();
    }

    private void readUserExpense() {
        System.out.println("Input your expense: ");
        this.expense = getUserAmount();
    }

    private void readUserIncome() {
        System.out.println("Input your income: ");
        this.income = getUserAmount();
    }

    private double getUserAmount() {
        double amount;
        while (true) {
            try {
                amount = new Scanner(System.in).nextDouble();
                if (amount <= 0 || amount > MAX_VALUE_OF_EXPENSE) {
                    System.out.println(Menu.ALERT_MESSAGE);
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(Menu.ALERT_MESSAGE);
            }
        }
        return amount;
    }

    private void setExpensesList() {
        System.out.println(localDate + "\t" + categories + "\t" + expense);
        userExpense.add(new Expense(localDate, categories, expense));
        userExpense.forEach(System.out::println);
    }

    private void setIncomesList() {
        System.out.println(localDate + "\t" + income);
        userIncome.add(new Income(localDate, income));
        userIncome.forEach(System.out::println);
    }

    public List<Expense> getUserExpense() {
        return userExpense;
    }

    public List<Income> getUserIncome() {
        return userIncome;
    }

    public void setFilePathFromArgs(String[] args) {
        if (args.length != 0) {
            if (args.length == 1 && Pattern.matches("[a-zA-Z0-9]+[\\.]?[a-zA-Z]{3}", args[0])) {
                UserRepository.setDefaultExpenseFilePath(args[0]);
            } else {
                System.out.println("Incorrect input data!");
            }
        }
        System.out.println("Default expense file name is set to: " + UserRepository.getDefaultExpenseFilePath());
    }
}
