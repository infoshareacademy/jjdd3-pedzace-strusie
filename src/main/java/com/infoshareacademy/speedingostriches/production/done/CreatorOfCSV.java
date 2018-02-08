package com.infoshareacademy.speedingostriches.production.done;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class CreatorOfCSV {

    public String createFile() {

        Scanner source = new Scanner(System.in);

        System.out.println("Please enter name of your file: ");
        String fileName = source.nextLine();
        fileName = fileName + ".csv";

        File yourFile = new File(fileName);

        boolean fileExist = yourFile.exists();

        if (!fileExist) {
            try {
                yourFile.createNewFile();
                System.out.println("Your file  " + yourFile + " was created.");

            } catch (IOException e) {
                System.out.println();
            }
        } else {
            System.out.println("The file is exist. Please choose another name for the file :) ");
        }
        return fileName;
    }
}

