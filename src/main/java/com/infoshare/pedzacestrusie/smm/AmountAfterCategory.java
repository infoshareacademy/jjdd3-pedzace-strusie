package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;

public class AmountAfterCategory {

    private String date; //w formacje daty?

    private String categories;

    private double expense;


    public AmountAfterCategory (String date, String categories, double expense) {

        this.date = date;
        this.categories = categories;
        this.expense = expense;
    }

    public AmountAfterCategory() {

    }

    public String getData() {
        return date;
    }
    
    public void setData(String  date) {
        this.date = date;
    }

    public String getCategories() {

        //AmountAfterCategory amountAfterCategory = new AmountAfterCategory("2018-02-05", "Eat", 23.10);
        System.out.println("Enter the category after which you want to sum: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();

        return answer;
    }
    //może powinno być w nadklasie
    public int amount() {


        return 0;
    }







}
