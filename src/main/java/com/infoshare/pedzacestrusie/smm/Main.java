package com.infoshare.pedzacestrusie.smm;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        AmountAfterCategory myAmount = new AmountAfterCategory();
        Reader newReader = new Reader();
        ReaderOfCSV newReader1 = new ReaderOfCSV();

      // System.out.println(newReader.reader());

      // System.out.println(myAmount.writingListElements());

      // myAmount.amount();

     // newReader1.readFromFile("file.txt");

     /*   List<Expenses> example = Arrays.asList(
                new AmountAfterCategory("2018-02-10", "Food", 900),
                new AmountAfterCategory("2018-02-10", "Bill", 650),
                new AmountAfterCategory("2018-02-10", "Bill", 469),
                new AmountAfterCategory("2018-02-10", "Food", 714),
                new AmountAfterCategory("2018-02-10", "Bill", 230),
                new AmountAfterCategory("2018-02-10", "Food", 15),
                new AmountAfterCategory("2018-02-10", "Food", 200),
                new AmountAfterCategory("2018-02-10", "Bill", 350)
        );

       example.forEach(System.out::println);

       public static int amountAfterCategory(List<Expenses> example) {
            return example.stream()
                    .map(example::getCategories)
                    .reduce(0, (element,suma) -> element + suma);
        }*/

    }
}
