package com.infoshareacademy.speedingostriches;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class UpdateFile {

    public void UpdateMyFile(String theFile,int addYourExpense) {


        {
            Scanner source = new Scanner(System.in);

            try {
                PrintWriter yourText = new PrintWriter(theFile);
                Scanner sourceFile = new Scanner(theFile);

               sourceFile.hasNext();

               if (sourceFile.hasNext()!= false) {

                   for (int i = 0; i < addYourExpense; i++) {


                       System.out.println("Please enter some information.");
                       yourText.println(source.nextLine());
                   }

               }
                yourText.close();

            } catch (Exception e) {

                System.out.println("Your file is not exist!!!!");
            }


        }

    }
}