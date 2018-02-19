package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;

public class Expense {

    private LocalDate date;
    private String categories;
    private double expense;

    Expense(LocalDate date, String categories, double expense) {
        this.date = date;
        this.categories = categories;
        this.expense = expense;
    }

    public LocalDate getDate() {
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
        return "Expense{" +
                "date='" + date + '\'' +
                ", categories='" + categories + '\'' +
                ", expense=" + expense +
                '}';
    }
}
