package com.infoshare.pedzacestrusie.smm;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Maciej Wanagos
 */
public class Income {

    private List<Expenses> userExpenses = new ArrayList<Expenses>();

    /**
     * Income of user
     *
     * @param date       String date of making expenses
     * @param categories String category of expenses
     * @param expense    double value of expenses
     */
    public Income(String date, String categories, double expense) {

        userExpenses.add(new Expenses(date, categories, expense));

    }

    /**
     * Return List of user expenses
     *
     * @return List of expenses
     */
    public List<Expenses> getUserExpenses() {
        return userExpenses;
    }
}
