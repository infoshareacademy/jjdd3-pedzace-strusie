package com.infoshare.pedzacestrusie.smm;

import java.util.Arrays;
import java.util.List;

public class Expenses {

    String date;

    String categories;

    double expense;


    public Expenses (String date, String categories, double expense) {

        this.date = date;
        this.categories = categories;
        this.expense = expense;
    }

    public Expenses() {

    }

    public String getData() {
        return date;
    }

    public String getCategories() {return categories;}

    public double getExpense() {return expense;}

    @Override
    public String toString() {

        return date +", "+ categories +", "+  expense;
    }


}
