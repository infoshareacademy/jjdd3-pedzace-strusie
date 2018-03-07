package com.infoshareacademy.baseapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);

        logger.info("'sup? I'm your info logger");
        logger.debug("hey HEY hey! I'm your debug logger");
        new Settings().updateDefaults(args);
        new MainMenu().executeMenu();
    }
}
