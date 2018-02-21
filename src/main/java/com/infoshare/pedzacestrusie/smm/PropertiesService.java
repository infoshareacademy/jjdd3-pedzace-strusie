package com.infoshare.pedzacestrusie.smm;


import java.io.*;
import java.util.*;

public class PropertiesService {

    private Properties properties = new Properties();

    public String getCurrency() {
        return this.properties.getProperty("currency", "PLN");
    }

    public String getFormatDate() {
        return this.properties.getProperty("date-format", "yyyy-MM-dd");
    }

    public String getDefaultExpenseFilePath(){
        return this.properties.getProperty("defaultExpenseFilePath","Resources/expense.csv");
    }
    public String getDefaultCategoryFilePath(){
        return this.properties.getProperty("defaultCategoryFilePath","Resources/defaultCategories.csv");
    }

    public PropertiesService (){
        loadPropertyService();
    }

    private void loadPropertyService() {

        try {
            InputStream input = input = new FileInputStream("Resources/config.properties");
            properties.load(input);
            input.close();
        } catch (IOException e) {
            System.out.println("There is some problems with load the config data!!!" + e.getMessage());
        }
    }
}