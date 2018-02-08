package com.infoshare.pedzacestrusie.smm.create_read_write;


import java.io.BufferedReader;
import java.io.FileReader;


public class ReadCSV {


    public String readFromFile(String spendingData) throws Exception {

        FileReader myFile = new FileReader(spendingData);
        BufferedReader fileReader = new BufferedReader(myFile);


        String line = "";
        String temp = "";

        try {
            while ((line = fileReader.readLine()) != null) {
                temp += line + "\n";

            }
            System.out.println("Here is information read from file: ");
            System.out.println();
            System.out.println(temp);

            fileReader.close();

        } catch (Exception e) {
            System.out.println("File is not found.");
        }
        return temp;
    }
}
