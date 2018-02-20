package com.infoshare.pedzacestrusie.smm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //gets data from properties file
        UserRepository.setDateTimeFormatter("yyyy-MM-dd");
        UserRepository.setCurrency("PLN");

        //gets categories from settings file
        UserRepository.setCategoryUserRepository(new TreeSet<>(Arrays.asList("Cat01", "Cat02", "Cat03", "Cat04")));

        //gets data from agrs
        new InputService().setFilePathFromArgs(args);

//        new MainMenu().executeMenu();
    }

}
