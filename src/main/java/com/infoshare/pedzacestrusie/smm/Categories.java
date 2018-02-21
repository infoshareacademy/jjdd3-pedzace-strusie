package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Categories {

    private Set<String> categories = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

//    Categories() {
//        readCSV readFromFile = new readCSV();
//        categories.addAll(readFromFile("Categories.txt"));
//    }

    public Set<String> getCategories() {
        return categories;
    }

    //user case
    private void addCategory() {

        System.out.print("Type new category: \n(\"q\" will abort)\n");
        String input = readInput();

        if(isAborted(input)) {
            return;
        }

        categories.add(input);
        System.out.println("Added.");
    }

    //developer case
    public void addCategory(String category) {
        categories.add(category);
    }

    public void showCategories() {
        System.out.println("We have " + categories.size() + " categories.");
        System.out.println("Categories: " + categories);
    }

    //user case
    public void removeCategory() {
        showCategories();
        System.out.print("Type category to remove:\n(\"q\" will abort)\n");
        String input = readInput();

        if(isAborted(input)) {
            return;
        }

        if (categories.contains(input) == false) {
            System.out.println("There is no such category.");
        }
        else {
            categories.remove(input);
            System.out.println("Removed.");
        }
    }

    //developer case
    public void removeCategory(String category) {
        categories.remove(category);
    }

    public void restoreDefault() {

        System.out.println("Are you sure? This will remove any category added by you.\n" +
                "Type \"YES\" to delete, anything else will abort restoring.");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equals("YES")) {
            categories.clear();

//            readCSV readFromFile = new readCSV();
//            categories.addAll(readFromFile("defaultCategories.csv"));

            System.out.println("Restored.");

        } else {
            System.out.println("Aborted.");
        }
    }

    private String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private boolean isAborted(String input) {
        if(input.equals("q")) {
            System.out.println("Aborted.");
            return true;
        }

        return false;
    }
}
