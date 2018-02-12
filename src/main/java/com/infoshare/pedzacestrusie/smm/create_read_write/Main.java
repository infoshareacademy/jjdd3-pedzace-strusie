package com.infoshare.pedzacestrusie.smm.create_read_write;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

//        CreateCSV creator = new CreateCSV();
//        creator.createFile();

        ReadCSV reader = new ReadCSV();
        System.out.println(reader.readFromFileExpenses());



//        List<Expense> expenseList = Arrays.asList(
//                new Expense("2018-02-12", "food expense", 143.25),
//                new Expense("2018-02-20", "gasoline", 189.45)
//
//        );
//        WriteCSV writer = new WriteCSV();
//        writer.writeToTheCsvFile("expenses18.csv", expenseList);

    }


}

