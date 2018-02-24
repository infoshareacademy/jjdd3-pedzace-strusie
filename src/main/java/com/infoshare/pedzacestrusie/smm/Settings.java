package com.infoshare.pedzacestrusie.smm;

import com.infoshare.pedzacestrusie.smm.create_read_write.CsvReader;

import java.util.List;
import java.util.Set;

public class Settings {
    public void updateDefaults(String[] args) {
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
