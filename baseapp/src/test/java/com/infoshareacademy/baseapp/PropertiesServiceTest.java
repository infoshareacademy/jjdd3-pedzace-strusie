package com.infoshareacademy.baseapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesServiceTest {

    @Test
    void shouldGetRightValueOfCurrency() {
        // Given
        new Settings().updateDefaults(new String[0]);

        String expectedCurrency = "PLN";

        // When
        PropertiesService propertiesService = new PropertiesService();
        String actualCurrency = propertiesService.getCurrency();

        // Then
        assertEquals(expectedCurrency, actualCurrency);
    }

    @Test
    void shouldGetRightValueOfFormatDate() {
        // Given
        String expectedFromatDate = "yyyy-MM-dd";

        // When
        PropertiesService propertiesService = new PropertiesService();
        String actualFormatDate = propertiesService.getFormatDate();

        // Then
        assertEquals(expectedFromatDate, actualFormatDate);
    }

    @Test
    void shouldGetRightExpensesFilePath() {
        // Given
        String expectedExpensesFilePath = "Resources/expenses.csv";

        // When
        PropertiesService propertiesService = new PropertiesService();
        String actualExpensesFilePath = propertiesService.getExpensesFilePath();

        // Then
        assertEquals(expectedExpensesFilePath, actualExpensesFilePath);
    }

    @Test
    void shouldGetRightIncomesFilePath() {
        // Given
        String expectedIncomesFilePath = "Resources/incomes.csv";

        // When
        PropertiesService propertiesService = new PropertiesService();
        String actualIncomesFilePath = propertiesService.getIncomesFilePath();

        // Then
        assertEquals(expectedIncomesFilePath, actualIncomesFilePath);
    }

    @Test
    void shouldGetRightDefaultCategoriesFilePath() {
        // Given
        String expectedDefaultCategoriesFilePath = "Resources/defaultCategories.csv";

        // When
        PropertiesService propertiesService = new PropertiesService();
        String actualDefaultCategoriesFilePath = propertiesService.getDefaultCategoriesFilePath();

        // Then
        assertEquals(expectedDefaultCategoriesFilePath, actualDefaultCategoriesFilePath);
    }

    @Test
    void shouldGetRightUserCategoriesFilePath() {
        // Given
        String expectedUserCategoriesFilePath = "Resources/userCategories.csv";

        // When
        PropertiesService propertiesService = new PropertiesService();
        String actualUserCategoriesFilePath = propertiesService.getUserCategoriesFilePath();

        // Then
        assertEquals(expectedUserCategoriesFilePath, actualUserCategoriesFilePath);
    }
}