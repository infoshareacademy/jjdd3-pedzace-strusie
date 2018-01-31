package com.infoshareacademy.speedingostriches;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class WriteToFile {

    public void writeToFile(String monthlyData) {

        String fileName = monthlyData;

        try {

            PrintWriter out = new PrintWriter(fileName);
            out.println("Anna");
            out.println("Konrad");
            out.println("Daniel");

            out.close();



        } catch (FileNotFoundException e) {
            System.out.println("I can not find any file!!!");
        }
    }
}
