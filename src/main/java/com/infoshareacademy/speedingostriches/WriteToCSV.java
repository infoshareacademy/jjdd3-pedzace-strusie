package com.infoshareacademy.speedingostriches;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class WriteToCSV {


    public static void writeToTheCsvDFile(String fileName) {


        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write("next new value" + "\n");
            writer.write("some category of shopping" + "\n");
            writer.write("some expense" + "\n");
            writer.close();

        } catch (Exception e) {
        }

    }
}
