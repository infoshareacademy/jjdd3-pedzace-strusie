package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;

public class Expense {
    private LocalDate date;
    private String category;
    private double expense;

    public Expense(LocalDate date, String category, double expense) {
        this.date = date;
        this.category = category;
        this.expense = expense;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getExpense() {
        return expense;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", expense=" + expense + UserRepository.getCurrency()+
                '}';
    }
}
