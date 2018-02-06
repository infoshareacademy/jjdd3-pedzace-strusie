package com.infoshareacademy.speedingostriches.production.done;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class CreateFile {

    // it is needed to add functionality to ask user to add another name for the file

    public static String createFile() {

        // add object source to give ability enter characters from keyboard
        Scanner source = new Scanner(System.in);

        // add story to our file creator, ask user to put some name to the file
        //return some value into field fileName

        System.out.println("Please enter name of your file: ");
        String fileName = source.nextLine();
        fileName = fileName + ".csv";

        // create new object yourFile, use class File
        File yourFile = new File(fileName);

        // add condition of file existing

        boolean fileExist = yourFile.exists();

        // create if statement, if file is one the directory, we read message that file is exist
        if (!fileExist) {
            try {

                // create new file with method createNewFile()

                boolean createYourFile = yourFile.createNewFile();

                // confirmation that our file is created, return output message
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

