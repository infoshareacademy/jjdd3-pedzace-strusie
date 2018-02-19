package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.infoshare.pedzacestrusie.smm.Expense;
import com.infoshare.pedzacestrusie.smm.Income;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CSVWriter {

    public void writeToTheCsvFileExpenses(List<Expense> externalExpenseList, String externalFilePath) throws Exception {

        String fileName = externalFilePath;
        List<Expense> writeList = new ArrayList<>();

        for (Expense x : externalExpenseList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (Expense y : writeList) {
                writer.write(y.getDate() + ";" + y.getCategories() + ";" + y.getExpense() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }

    public void writeToTheCsvFileIncomes(List<Income> externalIncomeList, String externalFilePath) {

        String fileName = externalFilePath;
        List<Income> writeList = new ArrayList<>();

        for (Income x : externalIncomeList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (Income y : writeList) {
                writer.write(y.getDate() + ";" + y.getIncomes() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }

    public void writeToTheCsvFileCategories(TreeSet<String> externalCategoriesList, String externalFilePath) {

        String fileName = "categories-default.csv";
        List<String> writeList = new ArrayList<>();

        for (String x : externalCategoriesList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (String y : writeList) {
                writer.write(y.getCategories() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }
}
