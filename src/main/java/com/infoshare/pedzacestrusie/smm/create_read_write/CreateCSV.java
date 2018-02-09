package com.infoshare.pedzacestrusie.smm.create_read_write;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class CreateCSV {

    public void createFile() {

        String fileName = enterNameOfTheFile();
        generateFile(fileName);

    }

    private String enterNameOfTheFile() {

        Scanner source = new Scanner(System.in);

        System.out.println("Please enter name of your file: ");
        String fileName = source.nextLine();
        fileName = fileName + ".csv";

        return fileName;
    }

    private void generateFile(String nameOfFile) {

        File yourFile = new File(nameOfFile);
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
    }

}

