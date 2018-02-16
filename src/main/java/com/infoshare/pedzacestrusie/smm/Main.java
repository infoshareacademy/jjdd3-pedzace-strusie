package com.infoshare.pedzacestrusie.smm;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        AmountAfterCategory myAmount = new AmountAfterCategory();
        Reader newReader = new Reader();
        ReaderOfCSV newReader1 = new ReaderOfCSV();


//        Expenses expenses = new Expenses();

        List<Expenses> expenses = Arrays.asList(

                new Expenses ("2017-01-09", "food", 900),
                new Expenses ("2018-02-03", "bill", 650),
                new Expenses ("2018-01-09", "food", 469),
                new Expenses ("2014-01-04", "food", 714),
                new Expenses ("2018-01-09", "bill", 230),
                new Expenses ("2016-01-09", "bill", 15),
                new Expenses ("2018-01-09", "food", 200),
                new Expenses("2018-01-09", "bill", 350)
        );

        for(Expenses ex : SortByCategories.sortByCategories(expenses)){
            System.out.println(ex);
        }
        System.out.println("  ");
        for(Expenses data : SortByData.sortByData(expenses)){
            System.out.println(data);
        }
        System.out.println("  ");
        for(Expenses ex1 : AmountAfterCategory.amountAfterCategory(List<Expenses>))){
            System.out.println(ex1);
        }

    }

}
