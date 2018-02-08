package com.infoshare.pedzacestrusie.smm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

    //metoda reader czyta kategorię wpisaną przez użytkownika

       public String reader() {

            String categories;
            Scanner input = new Scanner(System.in);

        System.out.print("Enter category name: ");

        categories = input.nextLine();

        input.close();

        return "Yours category name is: " + categories;


    }

}


