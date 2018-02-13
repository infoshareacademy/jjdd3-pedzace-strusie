package com.infoshare.pedzacestrusie.smm;

public class Expenses {

    private String date;
    private String categories;
    private double expense;


//
//    public Expenses(String date, String categories, double expense) {
//        this.date = date;
//        this.categories = categories;
//        this.expense = expense;
//    }

    public String getDate() {
        return date;
    }

    public String getCategories() {
        return categories;
    }

    public double getExpense() {
        return expense;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "date='" + date + '\'' +
                ", categories='" + categories + '\'' +
                ", expense=" + expense +
                '}';
    }
}
