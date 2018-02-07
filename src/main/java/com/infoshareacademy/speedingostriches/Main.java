package com.infoshareacademy.speedingostriches;

import com.infoshareacademy.speedingostriches.production.done.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        //CreatorOfCSV.createFile();
//        ReaderOfCSV.readFromFile("marzec18.csv");

        // static method read some data from file, present it as a
        //UpdateToFile.updateToFile("styczen18.csv", null);

        //CollectionContener myContener = new CollectionContener();

        //myContener.addToLinkedList();

        WriteToCSV.writeToTheCsvFile("styczen18.csv");

//        String readFromCSV = ReaderOfCSV.readFromFile("marzec18.csv");


    }
}

