package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;
import java.util.TreeSet;

public class Categories {

    private TreeSet<String> categories = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);


    public TreeSet<String> getCategories() {
        return categories;
    }

        //user case
    public void addCategory() {

        System.out.print("Type new category: \n(\"q\" will abort)\n");
        Scanner scanner = new Scanner(System.in);
        String tempScanner = scanner.nextLine();

        if(tempScanner.equals("q")) {
            System.out.println("Aborted.");
        }
        else {
            categories.add(tempScanner);
            System.out.println("Added.");
        }
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
        System.out.print("Type category to remove:\n(\"q\" will abort)\n");
        Scanner scanner = new Scanner(System.in);
        String tempScanner = scanner.nextLine();

        if(tempScanner.equals("q")) {
            System.out.println("Aborted.");
        }
        else if (categories.contains(tempScanner) == false) {
            System.out.println("There is no such category.");
        }
        else {
            categories.remove(tempScanner);
            System.out.println("Removed.");
        }
    }

        //developer case
    public void removeCategory(String category) {
        categories.remove(category);
    }

    public void restoreDefault() {

        System.out.println("Are you sure? This will remove any category added by you.\nType \"YES\" to delete, anything else will abort restoring.");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equals("YES")) {
            categories.clear();

            categories.add("Accommodation");         // <-- DEFAULT CATEGORIES (alphabetical order)
            categories.add("Children");
            categories.add("Clothes");
            categories.add("Entertainment");
            categories.add("Food");
            categories.add("Healthcare");
            categories.add("Hygiene");
            categories.add("Loans");
            categories.add("Medias");
            categories.add("Others");
            categories.add("Savings");
            categories.add("Transportation");

            System.out.println("Restored.");

        } else {
            System.out.println("Aborted.");
        }
    }
}
