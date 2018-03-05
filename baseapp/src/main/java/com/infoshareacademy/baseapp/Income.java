package com.infoshareacademy.baseapp;

import java.time.LocalDate;

public class Income {

    private LocalDate date;
    private double income;

    public Income(LocalDate date, double income) {
        this.date = date;
        this.income = income;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Income{" +
                "date='" + date + '\'' +
                ", income=" + income + UserRepository.getCurrency() +
                '}';
    }
}