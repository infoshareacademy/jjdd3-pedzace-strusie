package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;
import java.util.TreeSet;

public class Categories {

    private TreeSet<String> categories = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);


        //user case
    public void addCategory() {

        System.out.print("Type new category: \n(\"q\" will abort)");
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();

        if(temp == "q") {
            System.out.println("Aborted.");
        }
        else {
            categories.add(temp);
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

    public void removeCategory() {
        System.out.print("Type category to remove:\n(\"q\" will abort)");
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();

        if(temp == "q") {
            System.out.println("Aborted.");
        }
        else if (categories.contains(temp) == false) {

        }
        else {
            categories.remove(temp);
            System.out.println("Added.");
        }
        }

        categories.remove(scanner.nextLine());
        System.out.println("Removed.");
    }

    public void restoreDefault() {

        System.out.println("Are you sure? This will remove any category added by you.\nType \"YES\" to delete, anything else will abort restoring.");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equals("YES")) {
            categories.clear();

            categories.add("Food");         // <-- DEFAULT CATEGORIES
            categories.add("Snacks");
            categories.add("Cleaning");
            categories.add("Something#1");
            categories.add("Something#2");
            categories.add("Something#3");
            categories.add("Something#4");

            System.out.println("Restored.");

        } else {
            System.out.println("Aborted.");
        }
    }
}
