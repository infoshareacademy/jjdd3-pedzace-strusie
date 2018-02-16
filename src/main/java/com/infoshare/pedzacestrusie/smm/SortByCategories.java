package com.infoshare.pedzacestrusie.smm;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortByCategories {

    public static List<Expenses> sortByCategories(List<Expenses> expenses) {
        return expenses.stream()
                .sorted((o1, o2) -> o1.getCategories().compareTo(o2.getCategories()))
                .collect(toList());
    }
}
