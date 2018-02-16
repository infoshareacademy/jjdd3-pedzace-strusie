package com.infoshare.pedzacestrusie.smm;

import java.util.List;

public class AmountAfterCategory {


    public static double amountAfterCategory(List<Expenses> expenses, String category) {
        return expenses.stream()
                .filter(e -> e.getCategories().equals(category))
                .mapToDouble(Expenses::getExpense)
                .sum();
    }



}



