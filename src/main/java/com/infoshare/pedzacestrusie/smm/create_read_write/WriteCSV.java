package com.infoshare.pedzacestrusie.smm.create_read_write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class WriteCSV {

    //Income someIncome = new Income("14-02-2018", "mortage", 1450.34);  // sample record to add to our .csv file

    //private List<Expenses> expenseList = (List<Expenses>) Arrays.asList(someIncome.getUserExpenses().get(0));  // part of code made by codebin

//    private String getDataFromExpenseList() {
//
//        String dateExpense = expenseList.get(0).getDate();
//        String categories = expenseList.get(0).getCategories();
//        String expense = String.valueOf(expenseList.get(0).getExpense());
//
//        return dateExpense + "; " + categories + "; " + expense + "PLN";
//    }

    public void writeToTheCsvFile(String fileName) {

        String writeValue = "some value";                                          //this.getDataFromExpenseList();

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            writer.write(writeValue + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("File is not exist!!!");
        }
    }
}
