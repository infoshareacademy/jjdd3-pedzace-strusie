package com.infoshare.pedzacestrusie.smm;

import java.util.Scanner;
import java.util.TreeSet;

public class Categories {

    private static TreeSet<String> categories = new TreeSet<>();


    public static void main() {

        System.out.print("Categories settings\n" +
                "---\n" +
                "Select option: \n" +
                "1. Add category\n" +
                "2. Show cate");


    }

    private static void addCategory() {
        System.out.print("Type new category: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        categories.add(answer);
        System.out.println("Added.");
    }

    private static void showCategories() {
        System.out.println("We have " + categories.size() + " categories.");
        System.out.println("Categories: " + categories);
    }


    private void removeCategory() {

    }

    private void restoreDefault() {

        System.out.println("Are you sure? Categories will be restored to default.\nType \"YES\" to delete, anything else will abort restoring.");
        Scanner scanner = new Scanner(System.in);
        String answer = answer = scanner.next();
        if(answer.equals("YES")) {
            System.out.println("Deleted.");
        }
        else {
            System.out.println("Aborted.");
        }
    }
}
