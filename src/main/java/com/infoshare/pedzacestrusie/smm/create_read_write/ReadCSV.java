package com.infoshare.pedzacestrusie.smm.create_read_write;


import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;


public class ReadCSV {


    public List<String> readFromFile(String spendingData) throws Exception {

        List<String> readList = new ArrayList<>();

        FileReader myFile = new FileReader(spendingData);
        BufferedReader fileReader = new BufferedReader(myFile);

        String line = "";

        try {
            while ((line = fileReader.readLine()) != null) {
                readList.add(line);
            }
//
            fileReader.close();

        } catch (Exception e) {
            System.out.println("File is not found.");
        }
        return readList;
    }
}
