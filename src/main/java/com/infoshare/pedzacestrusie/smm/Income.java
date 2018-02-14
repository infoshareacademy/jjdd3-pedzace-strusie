package com.infoshare.pedzacestrusie.smm;

public class Income {

    private String date;
    private double incomes;

    public Income(String date, double incomes) {
        this.date = date;
        this.incomes = incomes;
    }

    public String getDate() {
        return date;
    }

    public double getIncomes() {
        return incomes;
    }

    @Override
    public String toString() {
        return "Income{" +
                "date='" + date + '\'' +
                ", incomes=" + incomes +
                '}';
    }
}
