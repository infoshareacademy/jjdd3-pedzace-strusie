package com.infoshare.pedzacestrusie.smm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Author: Maciej Wanagos
 */
public class Income {

    private List<Expenses> userExpenses = new ArrayList<Expenses>();
    private String date = "";
    private String categories;
    private double expense;


//    /**
//     * Income of user
//     *
//     * @param date       String date of making expenses
//     * @param categories String category of expenses
//     * @param expense    double value of expenses
//     */


//    public Income(String date, String categories, double expense) {
//
//        userExpenses.add(new Expenses(date, categories, expense));
//
//    }
//


    public Income() {
        this.getUserExpenses();
//        this.getUserDate();
//        this.getFromUI("2001-02-31");
    }

    /**
     * Return List of user expenses
     *
     * @return List of expenses
     */
    public void getUserExpenses() {
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        while (!Pattern.matches("2[0-9][0-9][0-9]-[0-1][0-2]-[0-3][0-9]", date)) {
            try {

                //enter date of expenses
                System.out.println("Enter date[YYYY-MM-DD]: ");

                date = new Scanner(System.in).next();

                LocalDate localDate = LocalDate.parse(date, FORMATTER);

                System.out.println(localDate.getYear());
                System.out.println(localDate.getMonthValue());
                System.out.println(localDate.getDayOfMonth());

                if (!localDate.toString().equals(date)) {
                    throw new DateTimeParseException(null, "This is not parsable!", 1);
                }

            } catch (DateTimeParseException exc) {
                System.out.printf("%s is not parsable!%n", date);
                date = "";
//            } catch (Exception e) {
//                System.out.printf("%s is not parsable!%n", date);
//                continue;
            }
        }

//        return userExpenses;
    }

//
//
//    public LocalDate getFromUI(String input) {
//        try {
//            LocalDate date = LocalDate.parse(input, FORMATTER);
//            return date;
//        } catch (DateTimeParseException exc) {
//            System.out.printf("%s is not parsable!%n", input);
//            throw exc;      // Rethrow the exception.
//        }
//
//
//    }


}
