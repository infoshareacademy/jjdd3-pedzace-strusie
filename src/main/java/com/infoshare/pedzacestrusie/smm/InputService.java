package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class InputService {

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Set<String> categorySet = new TreeSet<>(Arrays.asList("Cat01", "Cat02", "Cat03"));
    private List<Expense> userExpense = new ArrayList<>();
    private String date = "";
    private String categories;
    private double expense;
    private LocalDate localDate = LocalDate.now();

    public InputService() {
        this.getUserExpenses();
//        this.printUserCategories(categorySet);
        this.readUserCategories();
        this.readUserExpenses();
        this.setListExpenses();
    }

    public void getUserExpenses() {
        while (!isDataFormatIsOk()) {
            try {
                this.getDateFromUser();
                this.parseDateFromUser();
            } catch (DateTimeParseException exc) {
                System.out.printf("%s is not parsable!%n", date);
                date = "";
            }
        }
    }

    private boolean isDataFormatIsOk() {
        return localDate.toString().equals(date);
    }

    private void getDateFromUser() {
        System.out.println("Enter date[YYYY-MM-DD]: ");
        date = new Scanner(System.in).next();
    }

    private void parseDateFromUser() {
        localDate = LocalDate.parse(date, FORMATTER);
    }

    public void printUserCategories(Set<String> categorySet) {
        String[] categories = categorySet.stream().toArray(String[]::new);
        String stringCategories = Arrays.stream(categories).reduce("", (i, a) -> i + a + "\t");
        System.out.println(stringCategories);
    }

    public void readUserCategories() {
//        System.out.println("Choose category: ");
//        categories = new Scanner(System.in).next();
        categories = new SubCategoriesMenu().getCategories();
        System.out.println(categories);
    }

    public void readUserExpenses() {
        System.out.println("Choose your expense: ");
        expense = new Scanner(System.in).nextDouble();
        System.out.println(expense);
    }

    public void setListExpenses() {
        System.out.println(localDate + "\t" + categories + "\t" + expense);
        userExpense.add(new Expense(localDate, categories, expense));
    }

}
