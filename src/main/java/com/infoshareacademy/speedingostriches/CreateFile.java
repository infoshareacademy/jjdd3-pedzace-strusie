package com.infoshareacademy.speedingostriches;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class CreateFile {

    Scanner source = new Scanner(System.in);

    public String createFile() {

        // entering the name of the file (used Scanner App)
        System.out.println("Please enter name of your file: ");
        String fileName = source.nextLine();
        fileName = fileName + ".csv";

        // Tworzenie nowego pliku na podstawie danych podanych
        File yourFile = new File(fileName);

        boolean fileExist = yourFile.exists();

        // sprawdzenie istnienia pliku z funkcją .exist()
        if (!fileExist) {
            try {
                fileExist = yourFile.createNewFile();
            } catch (IOException e) {
                System.out.println("System wasn't able to open your file.");
            }
        }
        // potwierdzenie utworzenia nowego pliku, wyrzucenie nazwy utworzonego pliku
        if (fileExist)
            System.out.println("Your file  " + yourFile + " was created.");
        return fileName;
    }

    public String KeyboardWriterString() {

        System.out.println("Please enter your text: ");
        String myString = source.nextLine();
        return myString;
    }

    public int KeyboardWriterInt() {
        System.out.println("Please enter some value: ");
        int myValue = source.nextInt();

        return myValue;
    }
}
