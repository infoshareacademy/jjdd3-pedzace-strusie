package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.infoshare.pedzacestrusie.smm.Expense;
import com.infoshare.pedzacestrusie.smm.Income;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class CsvWriter {
    public void writeToExpensesCsvFile(List<Expense> externalExpenseList, String externalFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(externalFilePath, true))) {
            for (Expense output : externalExpenseList) {
                writer.write(output.getDate() + ";" + output.getCategory() + ";" + output.getExpense() + "\n");
            }
        } catch (IOException e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }

    public void writeToIncomesCsvFile(List<Income> externalIncomeList, String externalFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(externalFilePath, true))) {
            for (Income output : externalIncomeList) {
                writer.write(output.getDate() + ";" + output.getIncome() + "\n");
            }
        } catch (Exception e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }

    public void writeToCategoriesCsvFile(Set<String> externalCategoriesList, String externalFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(externalFilePath))) {
            for (String output : externalCategoriesList) {
                writer.write(output + "\n");
            }
        } catch (Exception e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }
}
