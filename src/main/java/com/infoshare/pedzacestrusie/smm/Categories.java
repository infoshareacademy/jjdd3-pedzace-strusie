package com.infoshare.pedzacestrusie.smm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Categories {

    static List<String> list = new ArrayList<String>();

    public static void restoreDefault() {

        System.out.println("Are you sure? Categories will be restored to default.\nType \"YES\" to delete, anything else will abort restoring.");
        Scanner scanner = new Scanner(System.in);
        String answer = answer = scanner.next();
        if(answer.equals("YES")) {
            list.clear();
            System.out.println("Deleted.");
        }
        else {
            System.out.println("Aborted.");
        }
    }
}
