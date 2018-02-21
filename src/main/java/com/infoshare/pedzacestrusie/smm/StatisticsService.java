package com.infoshare.pedzacestrusie.smm;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StatisticsService {

    public void amountByCategory(List<Expense> expenses) {
        Map<String, Double> sum = expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategories,
                        Collectors.summingDouble(Expense::getExpense)));

        Map sortMap = sum.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .peek((i) -> System.out.printf("Category:%20s\t\tExpense:%12.2f%s%n", i.getKey(), i.getValue(), UserRepository.getCurrency()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Double result = expenses.stream()
                .mapToDouble(Expense::getExpense)
                .sum();

        System.out.printf("%nTotal amount of expenses:%31.2f%s", result, UserRepository.getCurrency());
    }

    public double AmountAfterDay(List<Expense> expenses, String category) {
        return expenses.stream()
                .filter(e -> e.getCategories().equals(category))
                .mapToDouble(Expense::getExpense)
                .sum();
    }

    public List<Expense> sortByCategories(List<Expense> expenses) {
        return expenses.stream()
                .sorted((o1, o2) -> o1.getCategories().compareTo(o2.getCategories()))
                .collect(toList());
    }

    public List<Expense> sortByData(List<Expense> data) {
        return data.stream()
                .sorted((o1, o2) -> o1.getDate().compareTo(o2.getDate()))
                .collect(toList());
    }


    public List<Expense> sortByExpense(List<Expense> data) {
        return data.stream()
                .sorted((o1, o2) -> Double.compare(o1.getExpense(), o2.getExpense()))
                .collect(toList());


    }
}
