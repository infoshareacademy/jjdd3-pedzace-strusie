package com.infoshareacademy.baseapp;

public class Main {

    public static void main(String[] args) {
        new Settings().updateDefaults(args);
        new MainMenu().executeMenu();
    }
}
