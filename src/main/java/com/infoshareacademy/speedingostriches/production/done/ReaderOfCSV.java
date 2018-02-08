package com.infoshareacademy.speedingostriches.production.done;

import com.infoshare.pedzacestrusie.*;
import com.infoshare.pedzacestrusie.smm.Expenses;
import com.infoshare.pedzacestrusie.smm.Income;

import java.io.BufferedReader;
import java.io.FileReader;


public class ReaderOfCSV {


    public String readFromFile(String spendingData) throws Exception {

        // create new objects myFile and fileReader to read file and keep information into memory

        FileReader myFile = new FileReader(spendingData);
        BufferedReader fileReader = new BufferedReader(myFile);

        // define some field to keep information about data from file
        String line = "";
        String temp = "";

        try {
            // loop checks if field line keep some string data into memory if there is some text
            // into line then loop add it into field temp(orary), then loop show value of the field

            while ((line = fileReader.readLine()) != null) {
                temp += line + "\n";
                //System.out.println(temp);
            }
            System.out.println("Here is information read from file: ");
            System.out.println();
            System.out.println(temp);

            // instruction close buffer into memory, it is needed to clean space
            // into memory

            fileReader.close();


            // catch FileNotFound Exception   || in this moment exception is not serviced
        } catch (Exception e) {
            System.out.println("File is not found.");
        }
        return temp;
    }
}
