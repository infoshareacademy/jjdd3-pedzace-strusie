package com.roadrunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    File fileToWrite = new File("file.txt");

    public void writer (String nameFile) {

       // File fileToWrite = new File(nameFile);

        try{
            BufferedWriter write = new BufferedWriter(new FileWriter(fileToWrite));

            write.write("Value 1");
            write.write("Zosia 2");

            write.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}
