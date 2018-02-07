package com.infoshareacademy.speedingostriches.production.done;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class WriteToCSV {

    //create some simple array as an example

//    private List<String> expneseList = new ArrayList<String>();
//
//    public void someExampleArrays(){
//
//    }

//    public static <T> void writeToTheCsvFile(String fileName, List<T> expenseList)



    //method contain object class FileWriter and BufferWriter, it helps us to update information into
    //some choose file for ex. add next line to the .csv file
    //line 25-27 is only some values to show how methods works

    public static void writeToTheCsvFile(String fileName) {


        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write("next new value" + "\n");    // String.valueOf(expenseList.someValue)
            writer.write("some category of shopping" + "\n");
            writer.write("some expense" + "\n");
        // method close BufferReader, clean the memory
            writer.close();

        } catch (Exception e) {
            System.out.println();

        }

    }
}
