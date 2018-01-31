package com.infoshare.pedzacestrusie.smm;

public class Main {

    public static void main(String[] args){

            System.out.println(new Menu().setMenuItems());
            new Menu().chooseMenuItems(new Menu().setMenuItems());
        }
}
