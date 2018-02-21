package com.infoshare.pedzacestrusie.smm;

import com.infoshare.pedzacestrusie.smm.create_read_write.CSVReader;

public class Main {

    public static void main(String[] args) {

        //gets data from properties file
        PropertiesService service = new PropertiesService();
        UserRepository.setDateTimeFormatter(service.getFormatDate());
        UserRepository.setCurrency(service.getCurrency());
        UserRepository.setDefaultExpenseFilePath(service.getDefaultExpenseFilePath());
        UserRepository.setDefaultCategoryFilePath(service.getDefaultCategoryFilePath());

        //gets categories from settings file
        CSVReader csvReader = new CSVReader();
        UserRepository.setCategoryUserRepository(csvReader.readFromFileCategories(UserRepository.getDefaultCategoryFilePath()));

        //gets data from agrs
        new InputService().setFilePathFromArgs(args);
        System.out.println(UserRepository.getDefaultCategoryFilePath());

        new MainMenu().executeMenu();
    }
}
