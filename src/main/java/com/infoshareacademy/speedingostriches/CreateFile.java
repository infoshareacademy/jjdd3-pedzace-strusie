package com.infoshareacademy.speedingostriches;


import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class CreateFile {

    Scanner source = new Scanner(System.in);

    public String createFile() {

        System.out.println("Please enter name of your file: ");
        String fileName = source.nextLine();
        fileName = fileName + ".csv";

        File yourFile = new File(fileName);

        boolean fileExist = yourFile.exists();

        if (!fileExist) {
            try {
                fileExist = yourFile.createNewFile();
            } catch (IOException e) {
                System.out.println("System wasn't able to open your file.");
            }
        }
        if (fileExist)
            System.out.println("Your file  " + yourFile + " was created.");
        return fileName;
    }


}
