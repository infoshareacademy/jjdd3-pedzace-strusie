package com.infoshareacademy.speedingostriches;

import com.infoshareacademy.speedingostriches.production.done.*;

public class Main {

    public static void main(String[] args) throws Exception {

        CreatorOfCSV creator = new CreatorOfCSV();
        String fileName = creator.createFile();

//        ReaderOfCSV reader = new ReaderOfCSV();
//        reader.readFromFile("marzec18.csv");
//
//        WriteToCSV writer = new WriteToCSV();
//        writer.writeToTheCsvFile("marzec18.csv");

    }
}

