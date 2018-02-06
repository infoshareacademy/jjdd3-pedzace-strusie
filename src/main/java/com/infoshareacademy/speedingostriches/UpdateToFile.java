package com.infoshareacademy.speedingostriches;


import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class UpdateToFile {

    public static void updateToFile(String spendingData, String enterData) throws Exception {


        // create new objects myFile and fileWriter to write data and keep information into memory

        FileWriter myFile = new FileWriter(spendingData);
        BufferedWriter fileWriter = new BufferedWriter(myFile);

        FileReader readFile = new FileReader(spendingData);
        BufferedReader fileReader = new BufferedReader(readFile);
        // create sample ArrayList to show how method add data to the expected file

        String[] someItems = {"rainbow", "gun", "id", "retarded mushroom", "fancy restaurant", "rainman"};
        List<String> itemsList = new ArrayList<String>();

        try {

            // loop add example from the list to the ArrayList

            for (String a : someItems)
                itemsList.add(a);


            String line = "";

            while ((line = fileReader.readLine()) != null) {
                for (String c : itemsList)
                    fileWriter.write(c + "\n");

            }
            fileWriter.close();
            fileReader.close();

        } catch (Exception e) {


        }


    }
}