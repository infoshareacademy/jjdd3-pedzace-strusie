package com.infoshare.pedzacestrusie.smm;


import java.io.*;
import java.util.*;

public class PropertiesService {

    private Properties properties = new Properties();

    public PropertiesService() {
        loadPropertyService();
    }

    public String getFormatDate() {
        return this.properties.getProperty("date-format", "yyyy-MM-dd");
    }

    public String getCurrency() {
        return this.properties.getProperty("currency", "PLN");
    }

    private Properties loadPropertyService() {

        try {
            InputStream input = new FileInputStream("config.properties");
            this.properties.load(input);
            input.close();
        } catch (IOException e) {
            System.out.println("There is some problems with load the config data!!!" + e.getMessage());
        }
        return null;
    }
}

