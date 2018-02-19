package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;

public class Income {

    private LocalDate date;
    private double income;

    Income(LocalDate date, double income) {
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
                ", income=" + income +
                '}';
    }
}
