package com.infoshareacademy.baseapp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {
    @Test
    void shouldReadRightValueFromExpensesFile() {
     /*   // Given
        List<Expense> expectedExpense = new ArrayList<>();
        expectedExpense.add(0, new Expense(LocalDate.of(2018, 5, 1), "children", Double.parseDouble("135.44")));
        expectedExpense.add(1, new Expense(LocalDate.of(2018, 8, 7), "hygiene", Double.parseDouble("125.61")));
        expectedExpense.add(2, new Expense(LocalDate.of(2018, 8, 23), "health", Double.parseDouble("43.66")));

        String expected = String.valueOf(expectedExpense);

        // When
        String testExpensesFile = "src/test/resources/expenses_test.csv";
        CsvReader csvReader = new CsvReader();
        List<Expense> actualExpense = csvReader.readFromFileExpenses(testExpensesFile);
        String actual = String.valueOf(actualExpense);

        // Then
        assertEquals(expected, actual);*/

    }

    @Test
    void shouldReadRightValueFromIncomeFile() {
  /*      // Given
        List<Income> expectedIncome = new ArrayList<>();
        expectedIncome.add(0, new Income(LocalDate.of(2018, 1, 8), Double.parseDouble("4450.47")));
        expectedIncome.add(1, new Income(LocalDate.of(2018, 2, 10), Double.parseDouble("6562.15")));
        expectedIncome.add(2, new Income(LocalDate.of(2018, 3, 17), Double.parseDouble("6095.16")));

        String expected = String.valueOf(expectedIncome);

        // When
        String testIncomeFile = "src/test/resources/incomes_test.csv";
        CsvReader csvReader = new CsvReader();
        List<Income> actualIncome = csvReader.readFromFileIncomes(testIncomeFile);
        String actual = String.valueOf(actualIncome);

        // Then
        assertEquals(expected, actual);*/
    }

    @Test
    void shouldReadRightValueFromCategoriesFile() {
  /*      // Given
        Set<String> expectedCategories = new TreeSet<>();
        expectedCategories.add("accommodation");
        expectedCategories.add("broadband");
        expectedCategories.add("children");
        expectedCategories.add("clothes");
        expectedCategories.add("entertainment");

        String expected = String.valueOf(expectedCategories);

        // When
        String testDefaultCategoriesFile = "src/test/resources/defaultCategories_test.csv";
        CsvReader csvReader = new CsvReader();
        Set<String> actualCategories = csvReader.readCategoriesFromFile(testDefaultCategoriesFile);
        String actual = String.valueOf(actualCategories);

        // Then
        assertEquals(expected, actual);*/
    }
}