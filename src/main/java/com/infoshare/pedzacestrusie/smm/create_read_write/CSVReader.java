package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.infoshare.pedzacestrusie.smm.Expenses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class CSVReader {

    public List<Expenses> readFromFileExpenses() throws Exception {

        String expensesData = "expenses18.csv";
        List<Expenses> readListExp = new ArrayList<>();

        BufferedReader fileReader =filePreparation(expensesData);

        String line = null;
        try {
            while ((line = fileReader.readLine()) != null) {
                String[] arrays = line.split(";");
                Expenses expense = new Expenses(null, null, 0);
                expense.setDate(arrays[0]);
                expense.setCategories(arrays[1]);
                expense.setExpense(Double.parseDouble(arrays[2]));
                readListExp.add(expense);
            }
            fileReader.close();
        } catch (FileNotFoundException e){
            System.out.println("There is some problems with read data from file!!!   " + e.getMessage());
        }


        return readListExp;
    }

    public List<Incomes> readFromFileIncomes() throws Exception {

        String incomesData = "incomes18.csv";
        List<Incomes> readListInc = new ArrayList<>();

        BufferedReader fileReader =filePreparation(incomesData);
        String line = null;
        try {
            while ((line = fileReader.readLine()) != null) {

                String[] arrays = line.split(";");
                Incomes income = new Incomes(null, 0.0);
                income.setDate(arrays[0]);
                income.setIncomes(Double.parseDouble(arrays[1]));
                readListInc.add(income);
            }
            fileReader.close();
        } catch (FileNotFoundException e){
            System.out.println("There is some problems with read data from file!!!   " + e.getMessage());
        }


        return readListInc;
    }

    public TreeSet<String> readFromFileCategories() throws Exception {

        String categories = "categories-default.csv";
        TreeSet<String> readListCat = new TreeSet<>();

        BufferedReader fileReader =filePreparation(categories);

        String line = null;

        try {
            while ((line = fileReader.readLine()) != null) {
                readListCat.add(line);
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("There is some problems with read data from file!!!   " + e.getMessage());
        }
        return readListCat;
    }

    private BufferedReader filePreparation (String inputFile) throws Exception{
        FileReader myFile = new FileReader(inputFile);
        BufferedReader fileReader = new BufferedReader(myFile);

        return fileReader;
    }
}
