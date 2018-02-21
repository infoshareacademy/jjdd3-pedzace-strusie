package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.infoshare.pedzacestrusie.smm.Expense;
import com.infoshare.pedzacestrusie.smm.Income;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class CSVReader {

    public List<Expense> readFromFileExpenses(String externalFilePath) {

        String expensesData = externalFilePath;
        List<Expense> readListExp = new ArrayList<>();
        BufferedReader fileReader = filePreparation(expensesData);
        String line=" ";

        try {
            while ((line = fileReader.readLine()) != null) {
                String[] arrays = line.split(";");
                Expense expense = new Expense(LocalDate.parse(arrays[0]), arrays[1], Double.parseDouble(arrays[2]));
                readListExp.add(expense);
            }
            fileReader.close();
            return readListExp;
        } catch (IOException e) {
            System.out.println("There is some problems with read data from file!!!   " + e.getMessage());
        }
        return null;
    }

    public List<Income> readFromFileIncomes(String externalFilePath) {

        String incomesData = externalFilePath;
        List<Income> readListInc = new ArrayList<>();
        BufferedReader fileReader = filePreparation(incomesData);
        String line=" ";

        try {
            while ((line = fileReader.readLine()) != null) {
                String[] arrays = line.split(";");
                Income income = new Income(LocalDate.parse(arrays[0]), Double.parseDouble(arrays[1]));
                readListInc.add(income);
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("There is problems with read data from file!!!   " + e.getMessage());
        } finally {

        }
        return readListInc;
    }

    public Set<String> readFromFileCategories(String externalFilePath) {

        String categories = externalFilePath;
        Set<String> readListCat = new TreeSet<>();
        BufferedReader fileReader = filePreparation(categories);
        String line=" ";

        try {
            while ((line = fileReader.readLine()) != null) {
                readListCat.add(line);
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("There is problems with read data from file!!!   " + e.getMessage());
        }
        return readListCat;
    }

    private BufferedReader filePreparation(String inputFile) {

        try {
            FileReader myFile = new FileReader(inputFile);
            BufferedReader fileReader = new BufferedReader(myFile);
            return fileReader;
        } catch (IOException e) {
            System.out.println("There is problems with read file!!!    " + e.getMessage());
        }
        return null;
    }
}
