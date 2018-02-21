package com.infoshare.pedzacestrusie.smm;

import com.infoshare.pedzacestrusie.smm.create_read_write.CSVReader;
import com.infoshare.pedzacestrusie.smm.create_read_write.CSVWriter;

import java.util.*;

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


        CSVReader csvReader = new CSVReader();
        List<Expense> expenseList;
        expenseList = csvReader.readFromFileExpenses("Resources/january18exp.csv");
        System.out.println(expenseList);
        UserRepository.setExpenseUserRepository(expenseList);

//        CSVReader csvReader2 = new CSVReader();
        Set<String> categoriesSet;
        categoriesSet = csvReader.readFromFileCategories("Resources/DefaultCategories.txt");
        System.out.println(categoriesSet);
        UserRepository.setCategoryUserRepository(categoriesSet);

//        CSVReader csvReader3 = new CSVReader();
        List<Income> incomeList;
        incomeList = csvReader.readFromFileIncomes("Resources/january18inc.csv");
        System.out.println(incomeList);
        UserRepository.setIncomeUserRepository(incomeList);


        CSVWriter csvWriter = new CSVWriter();
        List<Expense> expenseList2 = UserRepository.getExpenseUserRepository();
        csvWriter.writeToTheCsvFileExpenses(expenseList2,"Resources/testjanuary18exp.csv");
        System.out.println(expenseList2);

//        CSVWriter csvWriter2 = new CSVWriter();
        Set<String> categoriesSet2 = UserRepository.getCategoryUserRepository();
        csvWriter.writeToTheCsvFileCategories(categoriesSet2,"testDefaultCategories.txt");
        System.out.println(categoriesSet2);

//        CSVWriter csvWriter3 = new CSVWriter();
        List<Income> incomeList2 = UserRepository.getIncomeUserRepository();
        csvWriter.writeToTheCsvFileIncomes(incomeList2,"Resources/testincomes18.csv");
        System.out.println(incomeList2);


        PropertiesService service= new PropertiesService();
        System.out.println(service.getCurrency());
        System.out.println(service.getFormatDate());


    }

}
