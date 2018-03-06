package com.infoshareacademy.baseapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class Settings {
    Logger logger = LoggerFactory.getLogger(getClass().getName());
    public void updateDefaults(String[] args) {
        logger.info("run updateDefaults");

        PropertiesService service = new PropertiesService();

        UserRepository.setCurrency(service.getCurrency());
        UserRepository.setDateTimeFormatter(service.getFormatDate());
        UserRepository.setExpensesFilePath(service.getExpensesFilePath());
        UserRepository.setIncomesFilePath(service.getIncomesFilePath());
        UserRepository.setDefaultCategoriesFilePath(service.getDefaultCategoriesFilePath());
        UserRepository.setUserCategoriesFilePath(service.getUserCategoriesFilePath());

        updateCategorySetFromFile(UserRepository.getUserCategoriesFilePath());

        new InputService().setFilePathFromArgs(args);
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
