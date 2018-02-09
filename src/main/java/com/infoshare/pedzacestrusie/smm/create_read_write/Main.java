package com.infoshare.pedzacestrusie.smm.create_read_write;

import com.sun.xml.internal.ws.resources.SoapMessages;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

//        CreateCSV creator = new CreateCSV();
//        creator.createFile();

//        ReadCSV reader = new ReadCSV();
//        System.out.println(reader.readFromFile("marzec18.csv"));
//


        WriteCSV writer = new WriteCSV();
        writer.writeToTheCsvFile("marzec18.csv", sampleList);

    }


}

