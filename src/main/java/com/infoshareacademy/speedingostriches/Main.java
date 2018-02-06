package com.infoshareacademy.speedingostriches;

import com.infoshareacademy.speedingostriches.production.done.CreateFile;
import com.infoshareacademy.speedingostriches.production.done.ReadFromFile;

public class Main {

    public static void main(String[] args) throws Exception {

        //CreateFile.createFile();
        ReadFromFile.readFromFile("styczen18.csv");

        // static method read some data from file, present it as a
        //UpdateToFile.updateToFile("styczen18.csv", null);


    }
}

