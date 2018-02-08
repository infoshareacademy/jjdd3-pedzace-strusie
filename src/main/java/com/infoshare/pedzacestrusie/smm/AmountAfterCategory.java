package com.infoshare.pedzacestrusie.smm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmountAfterCategory {

    String date; 

    String categories;

    double expense;


    public AmountAfterCategory(String date, String categories, double expense) {

        this.date = date;
        this.categories = categories;
        this.expense = expense;
    }

    public AmountAfterCategory() {

    }

    public String getData() {
        return date;
    }

    public void setData(String date) {
        this.date = date;
    }


    public String writingListElements() {

        List<String> lista = new ArrayList<String>();

        String s = "ab,basd";
        String[] tab = s.split(",");

        //readerem czytam csv, dla każdej linii obiekt, setować pola, obiekt dodaję do listy,
        //tworzę listę przed pętlą.
        //streamy i filtrowanie -> na liście

        lista.add("2018-02-08");
        lista.add("drugi");

        return lista.get(1);
        //System.out.println(lista.get(1)); //wypisze "drugi"

    }

    public int amount() {

        int[] numbers = {1, 2, 3, 4, 5};

        for (int tmp : numbers) {
            System.out.println(tmp);
        }

        return numbers.length;

    }


}
