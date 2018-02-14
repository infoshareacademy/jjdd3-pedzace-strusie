package com.infoshare.pedzacestrusie.smm;

public class Income {

    private String date;
    private double income;

    public Income(String date, double income) {
        this.date = date;
        this.income = income;
    }

    public String getDate() {
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
