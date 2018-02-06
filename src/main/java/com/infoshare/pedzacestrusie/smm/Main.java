package com.infoshare.pedzacestrusie.smm;

public class Main {

    public static void main(String[] args) {


        Categories categories = new Categories();

        categories.addCategory("Food");         // <-- DEFAULT CATEGORIES
        categories.addCategory("Snacks");
        categories.addCategory("Cleaning");
        categories.addCategory("Something#1");
        categories.addCategory("Something#2");
        categories.addCategory("Something#3");
        categories.addCategory("Something#4");

        categories.restoreDefault();
        categories.showCategories();
        categories.addCategory();
        categories.showCategories();

    }
}
