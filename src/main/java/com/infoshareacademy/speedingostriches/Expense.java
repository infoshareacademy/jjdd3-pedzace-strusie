package com.infoshareacademy.speedingostriches;

import java.util.Date;

public class Expense {

    private String registerDate;
    private String categoryName;
    private double categroyValue;

    public String  getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getCategroyValue() {
        return categroyValue;
    }

    public void setCategroyValue(double categroyValue) {
        this.categroyValue = categroyValue;
    }


    public Expense(String registerDate, String categoryName, double categroyValue) {
        this.registerDate = registerDate;
        this.categoryName = categoryName;
        this.categroyValue = categroyValue;
    }



}
