package com.infoshareacademy.speedingostriches;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws Exception {

        //CreateFile myFile = new CreateFile();
        String theFile = "marzec18.csv";

        UpdateFile myUpdate = new UpdateFile();





        for (int i=0; i<1; i++) {
            myUpdate.UpdateMyFile(theFile, 3 );
        }


        //ReadFromFIle newRead = new ReadFromFIle();
        //newRead.readFromFile(theFile);


    }
}
