package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.infoshare.pedzacestrusie.smm.Expenses;
import com.infoshare.pedzacestrusie.smm.Incomes;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();

        List<Incomes> someIncome = Arrays.asList(
                new Incomes("2018-02-25", 354.20)
        );
        List<Expenses> someExpense = Arrays.asList(
                new Expenses("2018-02-23", "bułki z placu pigalle", 23.30)
        );

        writer.writeToTheCsvFileIncomes(someIncome);
        writer.writeToTheCsvFileExpenses(someExpense);



//        System.out.println(reader.readFromFileIncomes());
//        System.out.println(reader.readFromFileExpenses());
//        System.out.println(reader.readFromFileCategories());



    }


}

