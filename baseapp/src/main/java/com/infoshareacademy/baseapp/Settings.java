package com.infoshareacademy.baseapp;

import model.Expense;
import model.Income;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class Settings {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public void updateDefaults(String[] args) {
        PropertiesService service = new PropertiesService();

        UserRepository.setCurrency(service.getCurrency());
        UserRepository.setDateTimeFormatter(service.getFormatDate());
        UserRepository.setExpensesFilePath(service.getExpensesFilePath());
        UserRepository.setIncomesFilePath(service.getIncomesFilePath());
        UserRepository.setDefaultCategoriesFilePath(service.getDefaultCategoriesFilePath());
        UserRepository.setUserCategoriesFilePath(service.getUserCategoriesFilePath());
        logger.info("Set default properties");

        updateCategorySetFromFile(UserRepository.getUserCategoriesFilePath());
        logger.info("Update user categories");

        new InputService().setFilePathFromArgs(args);
        logger.info("Read file path from args");

    }

    public void updateExpenseListFromFile() {
        UserRepository.getExpensesUserRepository().clear();

        CsvReader csvReader = new CsvReader();
        List<Expense> expenseList;
        expenseList = csvReader.readFromFileExpenses(UserRepository.getExpensesFilePath());

        UserRepository.setExpensesUserRepository(expenseList);
    }

    public void updateIncomeListFromFile() {
        UserRepository.getIncomesUserRepository().clear();

        CsvReader csvReader = new CsvReader();
        List<Income> incomeList;
        incomeList = csvReader.readFromFileIncomes(UserRepository.getIncomesFilePath());

        UserRepository.setIncomesUserRepository(incomeList);
    }

    public void updateCategorySetFromFile(String filePath) {
        UserRepository.getCategoriesUserRepository().clear();

        CsvReader csvReader = new CsvReader();
        Set<String> categorySet;
        categorySet = csvReader.readCategoriesFromFile(filePath);

        UserRepository.setCategoriesUserRepository(categorySet);
    }
}
