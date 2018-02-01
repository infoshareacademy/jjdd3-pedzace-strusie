package com.infoshare.pedzacestrusie.smm;

public class Expenses {

    private String date;
    private String categories;
    private double expense;

    public Expenses(String date, String categories, double expense, String comment) {
        this.date = date;
        this.categories = categories;
        this.expense = expense;
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
