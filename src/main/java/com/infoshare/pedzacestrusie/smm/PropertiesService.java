package com.infoshare.pedzacestrusie.smm;


import java.io.*;
import java.util.*;

public class PropertiesService {

    Properties properties = new Properties();


    public void writePropertyService(String nameOfCurrency, String dateFormat) {
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream("config.properties");

            try {

                List<String> categoryList = addCategoryToList();

                for (int i = 0; i < categoryList.size() - 1; i++) {
                    properties.setProperty("name_of_category_" + (i + 1), categoryList.get(i));
                }

                properties.setProperty("currency", nameOfCurrency);
                properties.setProperty("date-format", dateFormat);

            } catch (NullPointerException e) {
                System.out.println("There is problem with writing to file" + e.getMessage());
            }
            properties.store(outputStream, null);

        } catch (IOException e) {
            System.out.println("File does not exist in system!!!" + e.getMessage());
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println("There is some problem to update file with properties!!!" + e.getMessage());
                }
        }
    }

    public void loadPropertyService() {
        InputStream input = null;

        try {
            input = new FileInputStream("config.properties");
            properties.load(input);

            List<String> propertiesList = new ArrayList<>();
            Iterator<String> iterator = properties.stringPropertyNames().iterator();

            while (iterator.hasNext()) {
                propertiesList.add(properties.getProperty(iterator.next()));
            }
            System.out.println(propertiesList.toString());

        } catch (IOException e) {
            System.out.println("There is some problems with load the config data!!!" + e.getMessage());
        }
    }

    private List<String> addCategoryToList() {

        List<String> categoryList = new ArrayList<>();
        Scanner source = new Scanner(System.in);
        String categoryName = " ";


        do {
            System.out.println("If you want to stop enter category name, please type: exit ");
            System.out.println("Please enter name of the category:  ");
            categoryName = source.nextLine();
            categoryList.add(categoryName);
        }
        while (!categoryName.equals("exit"));
        return categoryList;
    }


}