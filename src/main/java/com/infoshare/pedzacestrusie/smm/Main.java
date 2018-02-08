package com.infoshare.pedzacestrusie.smm;

public class Main {

    public static void main(String[] args) throws Exception {

        AmountAfterCategory myAmount = new AmountAfterCategory();
        Reader newReader = new Reader();
        ReaderOfCSV newReader1 = new ReaderOfCSV();

      // System.out.println(newReader.reader());

      // System.out.println(myAmount.writingListElements());

        myAmount.amount();

      newReader1.readFromFile("file.txt");

    }
}
