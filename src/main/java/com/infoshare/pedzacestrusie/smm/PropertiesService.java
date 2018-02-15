package com.infoshare.pedzacestrusie.smm;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesService {

    Properties properties = new Properties();

    OutputStream output = null;

    String configFile = "config.properties";

    public void writeService(String configFile) {

        try
        {
            output = new FileOutputStream(configFile);
            properties.setProperty("database", "localhost");
            properties.setProperty("dbuser", "danielkaras");

        } catch (FileNotFoundException e) {

            System.out.println("File does not exist!!" + e.getMessage());

        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    System.out.println("There is some problems with write data to file!!!" + e.getMessage());

                }

            }
        }
    }
}
