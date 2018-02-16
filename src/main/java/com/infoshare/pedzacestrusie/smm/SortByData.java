package com.infoshare.pedzacestrusie.smm;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortByData {
    public static List<Expenses> sortByData(List<Expenses> data) {
        return data.stream()
                .sorted((o1, o2) -> o1.getData().compareTo(o2.getData()))
                .collect(toList());
    }

}
