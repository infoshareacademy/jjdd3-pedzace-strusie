package com.infoshare.pedzacestrusie.smm;

public class Income {

    private String date;
    private double incomes;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getIncomes() {
        return incomes;
    }

    public void setIncomes(double incomes) {
        this.incomes = incomes;
    }

    @Override
    public String toString() {
        return "Income{" +
                "date='" + date + '\'' +
                ", incomes=" + incomes +
                '}';
    }
}
