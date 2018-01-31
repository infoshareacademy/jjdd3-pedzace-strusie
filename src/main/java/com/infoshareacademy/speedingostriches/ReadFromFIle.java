package com.infoshareacademy.speedingostriches;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFromFIle {


    public void readFromFile(String spendingsData) throws FileNotFoundException {

        String fileName = spendingsData;

        File file = new File(fileName);
        Scanner scanFile = new Scanner(file);

        try {
            int lines = 0;
            while (scanFile.hasNextLine()) {
                String name = scanFile.nextLine();
                System.out.println(name);
                lines++;
            }
            System.out.println("Ilość wierszy w pliku: " + lines);
        } catch (Exception e) {
            System.out.println("Twój plik nie został odnaleziony!!!");
        } finally {
            System.out.println("I'll do your job.");
            scanFile.close();
        }

    }
}
