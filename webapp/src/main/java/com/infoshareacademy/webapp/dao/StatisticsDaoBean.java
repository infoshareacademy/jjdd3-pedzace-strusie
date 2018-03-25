package com.infoshareacademy.webapp.dao;

import com.infoshareacademy.baseapp.CsvWriter;
import com.infoshareacademy.baseapp.Settings;
import com.infoshareacademy.baseapp.StatisticsService;
import com.infoshareacademy.baseapp.UserRepository;
import model.Expense;
import model.Income;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Stateless
public class StatisticsDaoBean implements StatisticsDao {

    @Override
    public Double findSumExpenses() {
        new Settings().updateDefaults(new String[]{""});
        new Settings().updateExpenseListFromFile();
        List<Expense> expenses = UserRepository.getExpensesUserRepository();

        LocalDate minDatePeriod = LocalDate.of(2017, 6, 1);
        LocalDate maxDatePeriod = LocalDate.of(2018, 1, 1);

        List<Expense> periodExpensesList = new StatisticsService().getPeriodExpenses(expenses, minDatePeriod, maxDatePeriod);

        return new StatisticsService().getSumOfExpenses(periodExpensesList);
    }

    @Override
    public Double findSumIncomes() {
        new Settings().updateDefaults(new String[]{""});
        new Settings().updateIncomeListFromFile();
        List<Income> incomes = UserRepository.getIncomesUserRepository();

        LocalDate minDatePeriod = LocalDate.of(2017, 6, 1);
        LocalDate maxDatePeriod = LocalDate.of(2018, 1, 1);

        List<Income> periodIncomesList = new StatisticsService().getPeriodIncomes(incomes, minDatePeriod, maxDatePeriod);

        return new StatisticsService().getSumOfIncomes(periodIncomesList);
    }


    @Override
    public Map<String, Double> findExpensesByCategory() {
        new Settings().updateDefaults(new String[]{""});
        new Settings().updateExpenseListFromFile();

        List<Expense> expenses = UserRepository.getExpensesUserRepository();
        LocalDate minDatePeriod = LocalDate.of(2017, 6, 1);
        LocalDate maxDatePeriod = LocalDate.of(2018, 1, 1);

        List<Expense> periodExpensesList = new StatisticsService().getPeriodExpenses(expenses, minDatePeriod, maxDatePeriod);

        Map<String, Double> mapByCategories = periodExpensesList.stream()
                .collect(Collectors.groupingBy(Expense::getCategory,
                        Collectors.summingDouble(Expense::getExpense)));

        return new TreeMap<>(mapByCategories);
    }

    @Override
    public Map<String, Double> findExpensesByMonths() {
        new Settings().updateDefaults(new String[]{""});
        new Settings().updateExpenseListFromFile();

        List<Expense> expenses = UserRepository.getExpensesUserRepository();
        LocalDate minDatePeriod = LocalDate.of(2017, 6, 1);
        LocalDate maxDatePeriod = LocalDate.of(2018, 1, 1);

        List<Expense> periodExpensesList = new StatisticsService().getPeriodExpenses(expenses, minDatePeriod, maxDatePeriod);

        Map<String, Double> mapByCategories = periodExpensesList.stream()
                .collect(Collectors.groupingBy(e -> String.format("%d, %tm(%s)", e.getDate().getYear(), e.getDate().getMonth(), e.getDate().getMonth()),
                        Collectors.summingDouble(Expense::getExpense)));

        return new TreeMap<>(mapByCategories);
    }

    @Override
    public void save(String newCategory) {
        new Settings().updateDefaults(new String[]{""});
        Set<String> categorySet = UserRepository.getCategoriesUserRepository();
        categorySet.add(newCategory);
        new CsvWriter().writeToCategoriesCsvFile(categorySet, UserRepository.getUserCategoriesFilePath());
    }

    @Override
    public void update() {
        new Settings().updateDefaults(new String[]{""});
//        new CategoriesService().restoreDefaultCategories();

        new Settings().updateCategorySetFromFile(UserRepository.getDefaultCategoriesFilePath());
        new CsvWriter().writeToCategoriesCsvFile(UserRepository.getCategoriesUserRepository(), UserRepository.getUserCategoriesFilePath());

    }

    @Override
    public void delete(String removeCategory) {
        new Settings().updateDefaults(new String[]{""});
        Set<String> categorySet = UserRepository.getCategoriesUserRepository();
        categorySet.remove(removeCategory);
        new CsvWriter().writeToCategoriesCsvFile(categorySet, UserRepository.getUserCategoriesFilePath());
    }


    @Override
    public boolean contains(String name) {
        new Settings().updateDefaults(new String[]{""});
        Set<String> categorySet = UserRepository.getCategoriesUserRepository();
        for (String category : categorySet) {
            if (category.equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<String> findAll() {
        new Settings().updateDefaults(new String[]{""});
        return UserRepository.getCategoriesUserRepository();
    }
}
