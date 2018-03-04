package com.infoshareacademy.baseapp;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsService {
    public void printAmountByCategoriesByPeriod(List<Expense> expenses, List<Income> incomes, LocalDate minDatePeriod, LocalDate maxDatePeriod) {
        List<Expense> periodExpensesList = expenses.stream()
                .filter(i -> i.getDate().isBefore(maxDatePeriod) && i.getDate().isAfter(minDatePeriod))
                .collect(Collectors.toList());

        List<Income> periodIncomesList = incomes.stream()
                .filter(i -> i.getDate().isBefore(maxDatePeriod) && i.getDate().isAfter(minDatePeriod))
                .collect(Collectors.toList());

        printAmountByCategories(periodExpensesList, periodIncomesList);
    }

    private void printAmountByCategories(List<Expense> expenses, List<Income> incomes) {
        printPeriod(expenses);

        Map<String, Double> mapByCategories = expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategory,
                        Collectors.summingDouble(Expense::getExpense)));

        mapByCategories.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach((i) -> System.out.printf("Category:%20s,\t\tExpense:%12.2f%s%n", i.getKey(), i.getValue(), UserRepository.getCurrency()));

        Double resultIncome = incomes.stream()
                .mapToDouble(Income::getIncome)
                .sum();

        System.out.printf("%nTotal amount of revenue:%32.2f%s%n", resultIncome, UserRepository.getCurrency());
        Double resultExpense = expenses.stream()
                .mapToDouble(Expense::getExpense)
                .sum();

        System.out.printf("Total amount of expenditure:%28.2f%s%n", resultExpense, UserRepository.getCurrency());
        System.out.printf("Total profit:%43.2f%s%n", resultIncome - resultExpense, UserRepository.getCurrency());
    }

    private void printPeriod(List<Expense> periodList) {
        Optional<Expense> minDate = periodList.stream().min(Comparator.comparing(Expense::getDate));
        System.out.println("Min date: " + minDate.get().getDate());

        Optional<Expense> maxDate = periodList.stream().max(Comparator.comparing(Expense::getDate));
        System.out.println("Max date: " + maxDate.get().getDate());

        System.out.printf("Period date is from %s to %s.%n", String.valueOf(minDate.get().getDate()), String.valueOf(maxDate.get().getDate()));
    }

    public void printAmountByDateByPeriod(List<Expense> expenses, LocalDate minDatePeriod, LocalDate maxDatePeriod) {
        List<Expense> periodList = expenses.stream()
                .filter(i -> i.getDate().isBefore(maxDatePeriod) && i.getDate().isAfter(minDatePeriod))
                .collect(Collectors.toList());

        printAmountByDate(periodList);
    }

    private void printAmountByDate(List<Expense> expenses) {
        printPeriod(expenses);

        Map<String, Double> mapByCategories = expenses.stream()
                .collect(Collectors.groupingBy(e -> String.format("%d, %tm(%s)", e.getDate().getYear(), e.getDate().getMonth(), e.getDate().getMonth()),
                        Collectors.summingDouble(Expense::getExpense)));

        mapByCategories.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach((i) -> System.out.printf("Month:%24s.\t\tExpense:%12.2f%s%n", i.getKey(), i.getValue(), UserRepository.getCurrency()));

        Double result = expenses.stream()
                .mapToDouble(Expense::getExpense)
                .sum();

        System.out.printf("%nTotal amount of expenditure:%28.2f%s%n", result, UserRepository.getCurrency());
    }

    public void printAmountByDateByCategoriesByPeriod(List<Expense> expenses, LocalDate minDatePeriod, LocalDate maxDatePeriod) {
        List<Expense> periodList = expenses.stream()
                .filter(i -> i.getDate().isBefore(maxDatePeriod) && i.getDate().isAfter(minDatePeriod))
                .collect(Collectors.toList());

        printAmountByDateByCategories(periodList);
    }

    private void printAmountByDateByCategories(List<Expense> expenses) {
        printPeriod(expenses);

        Map<String, Map<String, Double>> mapByCategories = expenses.stream()
                .collect(Collectors.groupingBy(e -> String.format("%d, %tm(%s)", e.getDate().getYear(), e.getDate().getMonth(), e.getDate().getMonth()),
                        Collectors.groupingBy(Expense::getCategory, Collectors.summingDouble(Expense::getExpense))));

        Map<String, Map<String, Double>> sortMap = mapByCategories.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        sortMap.forEach((key, value) -> {
            System.out.printf("%nDate:%20s%n", key);
            value.forEach((keyInside, valueInside) -> System.out.printf("Category:%20s,\t\tExpense:%12.2f%s%n", keyInside, valueInside, UserRepository.getCurrency()));
        });

        Double result = expenses.stream()
                .mapToDouble(Expense::getExpense)
                .sum();

        System.out.printf("%nTotal amount of expenditure:%28.2f%s%n", result, UserRepository.getCurrency());
    }
}
