package com.infoshare.pedzacestrusie.smm;

import java.util.ArrayList;
import java.util.List;


public class Income {

    List<Expenses> userExpenses= new ArrayList<Expenses>();


    public Income(String date, String categories, double expense, String comment){

        userExpenses.add(new Expenses(date, categories, expense, comment ));

        System.out.println(userExpenses.get(0));
    }

}
