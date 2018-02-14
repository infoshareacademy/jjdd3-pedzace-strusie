package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.infoshare.pedzacestrusie.smm.Expenses;
import com.infoshare.pedzacestrusie.smm.Incomes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class CSVReader {

    public List<Expenses> readFromFileExpenses() throws Exception {

        String expensesData = "expenses18.csv";
        List<Expenses> readListExp = new ArrayList<>();

        FileReader myFile = new FileReader(expensesData);
        BufferedReader fileReader = new BufferedReader(myFile);
        String line = null;

        while ((line = fileReader.readLine()) != null) {
            String[] arrays = line.split(";");
            Expenses expense = new Expenses(null, null, 0);
            expense.setDate(arrays[0]);
            expense.setCategories(arrays[1]);
            expense.setExpense(Double.parseDouble(arrays[2]));
            readListExp.add(expense);
        }
        fileReader.close();

        return readListExp;
    }

    public List<Incomes> readFromFileIncomes() throws Exception {

        String incomesData = "incomes18.csv";
        List<Incomes> readListInc = new ArrayList<>();

        FileReader myFile = new FileReader(incomesData);
        BufferedReader fileReader = new BufferedReader(myFile);
        String line = null;

        while ((line = fileReader.readLine()) != null) {

            String[] arrays = line.split(";");
            Incomes income = new Incomes(null, 0.0);
            income.setDate(arrays[0]);
            income.setIncomes(Double.parseDouble(arrays[1]));
            readListInc.add(income);
        }
        fileReader.close();

        return readListInc;
    }

    public TreeSet<String> readFromFileCategories() throws Exception {

        String incomesData = "categories-default.csv";
        TreeSet<String> readListCat = new TreeSet<>();

        FileReader myFile = new FileReader(incomesData);
        BufferedReader fileReader = new BufferedReader(myFile);
        String line = null;

        try {
            while ((line = fileReader.readLine()) != null) {
                readListCat.add(line);
            }
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readListCat;
    }
}
