package com.roadrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    private String namesFile;

    public void reader(String namesFile) {
        this.namesFile = namesFile;

        //com.roadrunner.Reader o = new com.roadrunner.Reader();


        File fileReader = new File("./file.txt");


        try {
            BufferedReader read = new BufferedReader(new FileReader(namesFile));

            String row = null;
            while ((row = read.readLine()) != null) {
                System.out.println(row);
            }

            read.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


