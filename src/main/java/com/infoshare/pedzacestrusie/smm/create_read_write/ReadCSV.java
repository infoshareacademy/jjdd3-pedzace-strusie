package com.infoshare.pedzacestrusie.smm.create_read_write;


import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ReadCSV {

    public List<Expense> readFromFileExpenses() throws Exception {

        String expensesData = "expenses18.csv";
        List<Expense> readListExp = new ArrayList<>();

        FileReader myFile = new FileReader(expensesData);
        BufferedReader fileReader = new BufferedReader(myFile);
        String line = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            while ((line = fileReader.readLine()) != null) {

                String[] arrays = line.split(";");
                Expense expense = new Expense();
                expense.setDaateOfExpense(LocalDate.parse(arrays[0], dtf));
                expense.setCategoryOfExpense(arrays[1]);
                expense.setValueOfExpense(Double.parseDouble(arrays[2]));
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
        List<Expense> readListInc = new ArrayList<>();

        FileReader myFile = new FileReader(incomesData);
        BufferedReader fileReader = new BufferedReader(myFile);
        String line = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            while ((line = fileReader.readLine()) != null) {

                String[] arrays = line.split(";");
                Income income = new Income();
                income.setDateOfExpense(LocalDate.parse(arrays[0], dtf)); // tutaj dodaj informacje z klasy Income - data
                income.setCategoryOfExpense(arrays[1]); // tutaj dodaj info z klasy Income - wartość
                income.setValueOfExpense(Double.parseDouble(arrays[2])); // to usunąć
                readListInc.add(expense);
            }
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readListExp;

    }

    public List<Categories> readFromFileCategories() throws Exception {

        String incomesData = "categories-default.csv";
        List<Categories> readListCat = new ArrayList<>();

        FileReader myFile = new FileReader(incomesData);
        BufferedReader fileReader = new BufferedReader(myFile);
        String line = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            while ((line = fileReader.readLine()) != null) {

                String[] arrays = line.split(";");
                Categories category = new Categories();
                category.setDateOfExpense(LocalDate.parse(arrays[0], dtf)); // tutaj dodaj informacje z klasy Income - data
                //income.setCategoryOfExpense(arrays[1]); // tutaj dodaj info z klasy Income - wartość
                //income.setValueOfExpense(Double.parseDouble(arrays[2])); // to usunąć
                readListCat.add(category);
            }
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readListCat;

    }


}
