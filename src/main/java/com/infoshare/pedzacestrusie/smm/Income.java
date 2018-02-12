package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Income {

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private List<Expenses> userExpenses = new ArrayList<>();
    private String date = "";
    private String categories;
    private double expense;
    private LocalDate localDate = LocalDate.now();


    public Income() {
        this.getUserExpenses();
    }

    public void getUserExpenses() {
        while (!isDataFormatIsOk()) {
            try {
                this.getDateFromUser();
                this.parseDateFromUser();
            } catch (DateTimeParseException exc) {
                System.out.printf("%s is not parsable!%n", date);
                date = "";
            }
        }
    }

    private boolean isDataFormatIsOk() {
        return localDate.toString().equals(date);
    }

    private void getDateFromUser() {
        System.out.println("Enter date[YYYY-MM-DD]: ");
        date = new Scanner(System.in).next();
    }

    private void parseDateFromUser() {
        localDate = LocalDate.parse(date, FORMATTER);
    }
}
