package com.infoshare.pedzacestrusie.smm.create_read_write;


import org.junit.experimental.categories.Categories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class ReadCSV {

    public List<Expenses> readFromFileExpenses() throws Exception {

        String expensesData = "expenses18.csv";
        List<Expenses> readListExp = new ArrayList<>();

        FileReader myFile = new FileReader(expensesData);
        BufferedReader fileReader = new BufferedReader(myFile);
        String line = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            while ((line = fileReader.readLine()) != null) {
                String[] arrays = line.split(";");
                Expenses expense = new Expenses();
                expense.setDate(LocalDate.parse(arrays[0], dtf));
                expense.setCategories(arrays[1]);
                expense.setExpense(Double.parseDouble(arrays[2]));
                readListExp.add(expense);
            }
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readListExp;
    }

    public List<Income> readFromFileIncomes() throws Exception {

        String incomesData = "incomes18.csv";
        List<Income> readListInc = new ArrayList<>();

        FileReader myFile = new FileReader(incomesData);
        BufferedReader fileReader = new BufferedReader(myFile);
        String line = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            while ((line = fileReader.readLine()) != null) {

                String[] arrays = line.split(";");
                Income income = new Income();
                income.setDateOfIncome(LocalDate.parse(arrays[0], dtf));
                income.setValueOfIncome(Double.parseDouble(arrays[1]));
                readListInc.add(income);
            }
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readListInc;

    }

    public Set<Categories> readFromFileCategories() throws Exception {

        String incomesData = "categories-default.csv";
        Set<Categories> readListCat = new TreeSet<>();

        FileReader myFile = new FileReader(incomesData);
        BufferedReader fileReader = new BufferedReader(myFile);
        String line = null;

        try {
            while ((line = fileReader.readLine()) != null) {

                String[] arrays = line.split(";");
                Categories category = new Categories();
                category.setCategories(arrays[0]);
                readListCat.add(category);
            }
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readListCat;
    }
}
