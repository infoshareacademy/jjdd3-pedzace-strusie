package com.infoshare.pedzacestrusie.smm;

/**
 * Author: Maciej Wanagos
 */
public class Expenses {

    private String date;
    private String categories;
    private double expense;

    /**
     * User expenses
     *
     * @param date       String date of making expenses
     * @param categories String category of expenses
     * @param expense    double value of expenses
     */
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

    @Override
    public String toString() {
        return "Expenses{" +
                "date='" + date + '\'' +
                ", categories='" + categories + '\'' +
                ", expense=" + expense +
                '}';
    }
}
