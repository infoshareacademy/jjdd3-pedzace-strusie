package com.infoshareacademy.baseapp;

import model.Expense;
import model.Income;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class CsvReader {
    public List<Expense> readFromFileExpenses(String externalFilePath) {
        List<Expense> expenseList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(externalFilePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrays = line.split(";");
                Expense newExpense = new Expense(LocalDate.parse(arrays[0]), arrays[1], Double.parseDouble(arrays[2]));
                expenseList.add(newExpense);
            }
        } catch (IOException e) {
            System.out.println("There is some problems with read data from file!!!   " + e.getMessage());
        }
        return expenseList;
    }

    public List<Income> readFromFileIncomes(String externalFilePath) {
        List<Income> incomeList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(externalFilePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrays = line.split(";");
                Income newIncome = new Income(LocalDate.parse(arrays[0]), Double.parseDouble(arrays[1]));
                incomeList.add(newIncome);
            }
        } catch (IOException e) {
            System.out.println("There is problems with read data from file!!!   " + e.getMessage());
        }
        return incomeList;
    }

    public Set<String> readCategoriesFromFile(String externalFilePath) {
        Set<String> categoriesSet = new TreeSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(externalFilePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                categoriesSet.add(line);
            }
        } catch (IOException e) {
            System.out.println("There is problems with read data from file!!!   " + e.getMessage());
        }
        return categoriesSet;
    }
}
