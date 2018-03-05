package com.infoshareacademy.baseapp;

import java.util.*;

public class UserRepository {

    private static List<Expense> expensesUserRepository = new ArrayList<>();
    private static List<Income> incomesUserRepository = new ArrayList<>();
    private static Set<String> categoriesUserRepository = new TreeSet<>();

    private static String dateTimeFormatter;
    private static String currency;
    private static String expensesFilePath;
    private static String incomesFilePath;
    private static String defaultCategoriesFilePath;
    private static String userCategoriesFilePath;

    public static List<Expense> getExpensesUserRepository() {
        return expensesUserRepository;
    }

    public static void setExpensesUserRepository(List<Expense> expensesUserRepository) {
        UserRepository.expensesUserRepository = expensesUserRepository;
    }

    public static List<Income> getIncomesUserRepository() {
        return incomesUserRepository;
    }

    public static void setIncomesUserRepository(List<Income> incomesUserRepository) {
        UserRepository.incomesUserRepository = incomesUserRepository;
    }

    public static Set<String> getCategoriesUserRepository() {
        return categoriesUserRepository;
    }

    public static void setCategoriesUserRepository(Set<String> categoriesUserRepository) {
        UserRepository.categoriesUserRepository = categoriesUserRepository;
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

    public static String getExpensesFilePath() {
        return expensesFilePath;
    }

    public static void setExpensesFilePath(String expensesFilePath) {
        UserRepository.expensesFilePath = expensesFilePath;
    }

    public static String getIncomesFilePath() {
        return incomesFilePath;
    }

    public static void setIncomesFilePath(String incomesFilePath) {
        UserRepository.incomesFilePath = incomesFilePath;
    }

    public static String getDefaultCategoriesFilePath() {
        return defaultCategoriesFilePath;
    }

    public static void setDefaultCategoriesFilePath(String defaultCategoriesFilePath) {
        UserRepository.defaultCategoriesFilePath = defaultCategoriesFilePath;
    }

    public static String getUserCategoriesFilePath() {
        return userCategoriesFilePath;
    }

    public static void setUserCategoriesFilePath(String userCategoriesFilePath) {
        UserRepository.userCategoriesFilePath = userCategoriesFilePath;
    }
}
