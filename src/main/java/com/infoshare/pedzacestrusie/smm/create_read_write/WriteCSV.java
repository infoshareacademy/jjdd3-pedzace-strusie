package com.infoshare.pedzacestrusie.smm.create_read_write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteCSV {

    public void writeToTheCsvFile(String fileName, List<Expense> externalExpenseList) {

        List<Expense> writeList = new ArrayList<>();

        for (Expense x : externalExpenseList) {
            writeList.add(x);

        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (Expense y : writeList) {
                writer.write(y.getDaateOfExpense() + ";" + y.getCategoryOfExpense() + ";" + y.getValueOfExpense() + "\n");
            }

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("File is not exist!!!");
        }
    }
}
