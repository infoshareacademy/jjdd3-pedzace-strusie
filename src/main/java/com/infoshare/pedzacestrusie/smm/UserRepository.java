package com.infoshare.pedzacestrusie.smm;

import java.util.*;

public class UserRepository {

    private static List<Expense> expenseUserRepository = new ArrayList<>();
    private static List<Income> incomeUserRepository = new ArrayList<>();
    private static Set<String> categoryUserRepository = new TreeSet<>();

    private static String dateTimeFormatter;
    private static String currency;
    private static String defaultExpenseFilePath;
    private static String defaultCategoryFilePath;

    public static List<Expense> getExpenseUserRepository() {
        return expenseUserRepository;
    }

    public static void setExpenseUserRepository(List<Expense> expenseUserRepository) {
        UserRepository.expenseUserRepository = expenseUserRepository;
    }

    public static List<Income> getIncomeUserRepository() {
        return incomeUserRepository;
    }

    public static void setIncomeUserRepository(List<Income> incomeUserRepository) {
        UserRepository.incomeUserRepository = incomeUserRepository;
    }

    public static Set<String> getCategoryUserRepository() {
        return categoryUserRepository;
    }

    public static void setCategoryUserRepository(Set<String> categoryUserRepository) {
        UserRepository.categoryUserRepository = categoryUserRepository;
    }

    public static String getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public static void setDateTimeFormatter(String dateTimeFormatter) {
        UserRepository.dateTimeFormatter = dateTimeFormatter;
    }

    public static String getCurrency() {
        return currency;
    }

    public static void setCurrency(String currency) {
        UserRepository.currency = currency;
    }

    public static String getDefaultExpenseFilePath() {
        return defaultExpenseFilePath;
    }

    public static void setDefaultExpenseFilePath(String defaultExpenseFilePath) {
        UserRepository.defaultExpenseFilePath = defaultExpenseFilePath;
    }

    public static String getDefaultCategoryFilePath() {
        return defaultCategoryFilePath;
    }

    public static void setDefaultCategoryFilePath(String defaultCategoryFilePath) {
        UserRepository.defaultCategoryFilePath = defaultCategoryFilePath;
    }
}
