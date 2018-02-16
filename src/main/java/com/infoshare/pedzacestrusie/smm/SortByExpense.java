package com.infoshare.pedzacestrusie.smm;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortByExpense {


    public static List<Expenses> sortByExpense(List<Expenses> data) {
        return data.stream()
                .sorted((o1, o2) -> Double.compare(o1.getExpense(),o2.getExpense()))
                .collect(toList());


    }

}