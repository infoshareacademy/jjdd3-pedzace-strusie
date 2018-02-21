package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.infoshare.pedzacestrusie.smm.Expense;
import com.infoshare.pedzacestrusie.smm.Income;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CSVWriter {

    public void writeToTheCsvFileExpenses(List<Expense> externalExpenseList, String externalFilePath)  {

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
        } catch (IOException e) {
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
                writer.write(y.getDate() + ";" + y.getIncome() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }

    public void writeToTheCsvFileCategories(TreeSet<String> externalCategoriesList, String externalFilePath) {

        String fileName = externalFilePath;
        List<String> writeList = new ArrayList<>();

        for (String x : externalCategoriesList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (String y : writeList) {
                writer.write(y + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }
}
