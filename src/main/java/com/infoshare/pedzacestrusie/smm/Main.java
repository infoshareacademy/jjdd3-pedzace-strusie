package com.infoshare.pedzacestrusie.smm;

import com.infoshare.pedzacestrusie.smm.create_read_write.CsvReader;

public class Main {

    public static void main(String[] args) {

        //gets data from properties file
        PropertiesService service = new PropertiesService();
        UserRepository.setCurrency(service.getCurrency());
        UserRepository.setDateTimeFormatter(service.getFormatDate());
        UserRepository.setExpensesFilePath(service.getExpensesFilePath());
        UserRepository.setIncomesFilePath(service.getIncomesFilePath());
        UserRepository.setDefaultCategoriesFilePath(service.getDefaultCategoriesFilePath());
        UserRepository.setUserCategoriesFilePath(service.getUserCategoriesFilePath());

        //gets categories from settings file
        CsvReader csvReader = new CsvReader();
        UserRepository.setCategoriesUserRepository(csvReader.readFromFileCategories(UserRepository.getDefaultCategoriesFilePath()));

        //gets data from agrs
        new InputService().setFilePathFromArgs(args);
        System.out.println(UserRepository.getDefaultCategoriesFilePath());

        new MainMenu().executeMenu();
    }
}
