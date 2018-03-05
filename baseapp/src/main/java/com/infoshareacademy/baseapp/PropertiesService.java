package com.infoshareacademy.baseapp;


import java.io.*;
import java.util.*;

public class PropertiesService {

    private Properties properties = new Properties();

    public String getCurrency() {
        return this.properties.getProperty("currency", "PLN");
    }

    public String getFormatDate() {
        return this.properties.getProperty("date-format", "yyyy-MM-dd");
    }

    public String getExpensesFilePath() {
        return this.properties.getProperty("expensesFilePath", "userData/expenses.csv");
    }

    public String getIncomesFilePath() {
        return this.properties.getProperty("incomesFilePath", "userData/incomes.csv");
    }

    public String getDefaultCategoriesFilePath() {
//        return this.properties.getProperty("defaultCategoriesFilePath", Objects.requireNonNull(this.getClass().getClassLoader().getResource("defaultCategories.csv")).getPath());
        return this.properties.getProperty("defaultCategoriesFilePath", "userData/defaultCategories.csv");
    }

    public String getUserCategoriesFilePath() {
        return this.properties.getProperty("userCategoriesFilePath", "userData/userCategories.csv");
    }

    public PropertiesService() {
        loadPropertyService();
    }

    private void loadPropertyService() {
        try (InputStream input = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("There is some problems with load the config data!!!" + e.getMessage());
        }
    }
}