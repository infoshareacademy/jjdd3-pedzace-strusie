package com.infoshare.pedzacestrusie.smm;

import sun.reflect.generics.tree.Tree;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Set<String> catSet = new TreeSet<>();

        catSet.add("cat01");
        catSet.add("cat02");
        catSet.add("cat03");
        catSet.add("cat04");


//        new MainMenu();

        new Income().getUserCategorie(catSet);

    }
}
