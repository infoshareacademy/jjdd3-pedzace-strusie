package com.infoshareacademy.baseapp;

import java.time.LocalDate;

public class Expense {
    private LocalDate date;
    private String category;
    private double expense;

    public Expense() {
    }

    public Expense(LocalDate date, String category, double expense) {
        this.date = date;
        this.category = category;
        this.expense = expense;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Expense{");
        sb.append("date=").append(date);
        sb.append(", category='").append(category).append('\'');
        sb.append(", expense=").append(expense).append(UserRepository.getCurrency());
        sb.append('}');
        return sb.toString();
    }
}
