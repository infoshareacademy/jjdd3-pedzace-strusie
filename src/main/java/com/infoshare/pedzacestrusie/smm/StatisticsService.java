package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StatisticsService {
    private List<Expense> userExpense = UserRepository.getExpensesUserRepository();
    private List<Income> userIncome = UserRepository.getIncomesUserRepository();
    private Set<String> userCategories = UserRepository.getCategoriesUserRepository();


    public void amountByCategory(List<Expense> expenses) {
        printPeriod(expenses);

        Map<String, Double> mapByCategories = expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategories,
                        Collectors.summingDouble(Expense::getExpense)));

        Map sortMap = mapByCategories.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .peek((i) -> System.out.printf("Category:%20s\t\tExpense:%12.2f%s%n", i.getKey(), i.getValue(), UserRepository.getCurrency()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Double result = expenses.stream()
                .mapToDouble(Expense::getExpense)
                .sum();

        System.out.printf("%nTotal amount of expenses:%31.2f%s%n", result, UserRepository.getCurrency());
    }

    public void amountByCategoryByPeriod(List<Expense> expenses, LocalDate minDatePeriod, LocalDate maxDatePeriod) {

        List<Expense> periodList = expenses.stream()
                .filter(i -> i.getDate().isBefore(maxDatePeriod) && i.getDate().isAfter(minDatePeriod))
                .collect(toList());

        amountByCategory(periodList);
    }

    public void printPeriod(List<Expense> periodList) {
        Optional<Expense> minDate = periodList.stream().min(Comparator.comparing(Expense::getDate));
        System.out.println("Min date: " + minDate.get().getDate());

        Optional<Expense> maxDate = periodList.stream().max(Comparator.comparing(Expense::getDate));
        System.out.println("Max date: " + maxDate.get().getDate());

        System.out.printf("Period date is from %s to %s.%n", String.valueOf(minDate.get().getDate()), String.valueOf(maxDate.get().getDate()));
    }

    public void testAmountByCategory(List<Expense> expenses) {
        printPeriod(expenses);

        Map<String, Double> mapByCategories = expenses.stream()
                .collect(Collectors.groupingBy(e -> e.getDate().getMonth() + ", " + e.getDate().getYear(),
                        Collectors.summingDouble(Expense::getExpense)));

        Map sortMap = mapByCategories.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .peek((i) -> System.out.printf("M:%20s\t\tExpense:%12.2f%s%n", i.getKey(), i.getValue(), UserRepository.getCurrency()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Double result = expenses.stream()
                .mapToDouble(Expense::getExpense)
                .sum();

        System.out.printf("%nTotal amount of expenses:%31.2f%s%n", result, UserRepository.getCurrency());
    }
}
