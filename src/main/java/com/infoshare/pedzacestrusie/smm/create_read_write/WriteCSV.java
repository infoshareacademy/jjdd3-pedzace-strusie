package com.infoshare.pedzacestrusie.smm.create_read_write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class WriteCSV {

    public void writeToTheCsvFileExpenses(List<Expense> externalExpenseList) {

        String fileName = "expenses18.csv";
        List<Expense> writeList = new ArrayList<>();

        for (Expense x : externalExpenseList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (Expense y : writeList) {
                writer.write( y.getDaateOfExpense() + ";" + y.getCategoryOfExpense() + ";" + y.getValueOfExpense() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File is not exist!!!");
        }
    }

    public void writeToTheCsvFileIncomes(List<Income> externalIncomeList) {

        String fileName = "incomes18.csv";
        List<Income> writeList = new ArrayList<>();

        for (Income x : externalIncomeList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (Income y : writeList) {
                writer.write( y.getDateOfIncome() + ";"   + y.getValueOfIncome() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File is not exist!!!");
        }
    }

    public void writeToTheCsvFileIncomes(TreeSet<Categories> externalCategoriesList) {

        String fileName = "expenses18.csv";
        Set<Categories> writeList = new TreeSet<>();

        for (Categories x : externalIncomeList) {
            writeList.add(x);
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (Categories y : writeList) {
                writer.write( y.getCategories() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File is not exist!!!");
        }
    }


}
