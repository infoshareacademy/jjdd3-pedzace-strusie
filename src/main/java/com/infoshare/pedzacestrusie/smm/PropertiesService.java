package com.infoshare.pedzacestrusie.smm;


import java.io.*;
import java.util.*;

public class PropertiesService {

    Properties properties = new Properties();


    public String getCurrency() {
        String currency = this.properties.getProperty("currency", "PLN");
        return currency;
    }

    public String getFormatDate() {

        String formatDate = this.properties.getProperty("date-format", "yyyy-MM-dd");
        return formatDate;
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