package com.infoshare.pedzacestrusie.smm;

public class Incomes {

    private String date;
    private Double incomes;

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
        return "Incomes[" +
                "date='" + date + '\'' +
                ", incomes=" + incomes +
                ']';
    }
}
