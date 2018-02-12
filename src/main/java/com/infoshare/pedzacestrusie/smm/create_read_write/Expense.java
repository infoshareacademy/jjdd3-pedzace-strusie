package com.infoshare.pedzacestrusie.smm.create_read_write;

import java.io.ObjectInput;
import java.time.LocalDate;

public class Expense {

    private LocalDate daateOfExpense;
    private String categoryOfExpense;
    private double valueOfExpense;

    public LocalDate getDaateOfExpense() {
        return daateOfExpense;
    }

    public void setDaateOfExpense(LocalDate daateOfExpense) {
        this.daateOfExpense = daateOfExpense;
    }

    public String getCategoryOfExpense() {
        return categoryOfExpense;
    }

    public void setCategoryOfExpense(String categoryOfExpense) {
        this.categoryOfExpense = categoryOfExpense;
    }

    public double getValueOfExpense() {
        return valueOfExpense;
    }

    public void setValueOfExpense(double valueOfExpense) {
        this.valueOfExpense = valueOfExpense;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "daateOfExpense=" + daateOfExpense +
                ", categoryOfExpense='" + categoryOfExpense + '\'' +
                ", valueOfExpense=" + valueOfExpense +
                '}';
    }
}
