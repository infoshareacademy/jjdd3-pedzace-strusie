package com.infoshare.pedzacestrusie.smm;

public class Expenses {

    private String date;
    private String categories;
    private double expense;

    public Expenses() {
    }

    public Expenses(String date, String categories, double expense) {
        this.date = date;
        this.categories = categories;
        this.expense = expense;
    }

    public String getDate() {
        return date;
    }

    public String getCategories() {
        return categories;
    }

    public double getExpense() {
        return expense;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setExpense(double expense) {
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
