package com.infoshare.pedzacestrusie.smm.create_read_write;

import java.io.ObjectInput;

public class Expense  {

    private String daateOfExpense;
    private String categoryOfExpense;
    private double valueOfExpense;

    public String getDaateOfExpense() {
        return daateOfExpense;
    }

    public void setDaateOfExpense(String daateOfExpense) {
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

    public Expense(String daateOfExpense, String categoryOfExpense, double valueOfExpense) {
        this.daateOfExpense = daateOfExpense;
        this.categoryOfExpense = categoryOfExpense;
        this.valueOfExpense = valueOfExpense;
    }




}
