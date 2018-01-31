package com.infoshareacademy.speedingostriches;

import java.io.FileNotFoundException;

public class Main {

    public static void main (String []args) throws FileNotFoundException {

        CreateFile myFile = new CreateFile();
        String theFile = myFile.createFile();

        WriteToFile newWrite = new WriteToFile();
        newWrite.writeToFile(theFile);


        ReadFromFIle newRead = new ReadFromFIle();

        newRead.readFromFile(theFile);




    }
}
