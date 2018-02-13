package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.infoshare.pedzacestrusie.smm.Expenses;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        ReadCSV reader = new ReadCSV();
        System.out.println(reader.readFromFileIncomes());
        System.out.println(reader.readFromFileExpenses());

    }


}

