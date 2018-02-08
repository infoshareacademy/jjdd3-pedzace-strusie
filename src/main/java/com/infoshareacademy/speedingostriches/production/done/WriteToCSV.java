package com.infoshareacademy.speedingostriches.production.done;

import com.infoshare.pedzacestrusie.smm.Expenses;
import com.infoshare.pedzacestrusie.smm.Income;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class WriteToCSV {

    Income someIncome = new Income("14-02-2018", "mortage", 1450.34);  // sample record to add to our .csv file

    private List<Expenses> expenseList = (List<Expenses>) Arrays.asList(someIncome.getUserExpenses().get(0));  // part of code made by codebin

    private String getDataFromExpenseList() {

        String dateExpense = expenseList.get(0).getDate();
        String categories = expenseList.get(0).getCategories();
        String expense = String.valueOf(expenseList.get(0).getExpense());

        return dateExpense + "; " + categories + "; " + expense + "PLN";

    }

    public void writeToTheCsvFile(String fileName) {

        String writeValue = this.getDataFromExpenseList();

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            writer.write(writeValue + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("File is not exist!!!");
        }
    }
}
