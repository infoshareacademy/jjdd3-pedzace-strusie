package com.infoshare.pedzacestrusie.smm;


import java.io.*;
import java.util.*;

public class PropertiesService {

    Properties properties = new Properties();


    public String getCurrency() {
        return this.properties.getProperty("currency", "PLN");
    }

    public String getFormatDate() {
        return this.properties.getProperty("date-format", "yyyy-MM-dd");
    }

    public PropertiesService (){
        loadPropertyService();
    }

    private void loadPropertyService() {

        try {
            InputStream input = input = new FileInputStream("config.properties");
            properties.load(input);
            input.close();


        } catch (IOException e) {
            System.out.println("There is some problems with load the config data!!!" + e.getMessage());
        }
    }
}