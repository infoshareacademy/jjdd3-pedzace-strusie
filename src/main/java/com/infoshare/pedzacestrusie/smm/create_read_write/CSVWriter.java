package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.infoshare.pedzacestrusie.smm.Expenses;
import org.junit.experimental.categories.Categories;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CSVWriter {

    public void writeToTheCsvFileExpenses(List<Expenses> externalExpenseList) throws Exception {

        String fileName = "expenses18.csv";
        List<Expenses> writeList = new ArrayList<>();

        for (Expenses x : externalExpenseList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (Expenses y : writeList) {
                writer.write(y.getDate() + ";" + y.getCategories() + ";" + y.getExpense() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }

    public void writeToTheCsvFileIncomes(List<Incomes> externalIncomeList) {

        String fileName = "incomes18.csv";
        List<Incomes> writeList = new ArrayList<>();

        for (Incomes x : externalIncomeList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {


            for (Incomes y : writeList) {
                writer.write(y.getDate() + ";" + y.getIncomes() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }

    public void writeToTheCsvFileCategories(TreeSet<Categories> externalCategoriesList) {

        String fileName = "categories-default.csv";
        List<Categories> writeList = new ArrayList<>();

        for (Categories x : externalCategoriesList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (Categories y : writeList) {
                writer.write(y.getCategories() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File does not exist. I can't write your data!!! " + e.getMessage());
        }
    }
}
