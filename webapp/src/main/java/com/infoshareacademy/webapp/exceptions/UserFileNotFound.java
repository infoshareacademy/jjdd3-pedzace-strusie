package com.infoshareacademy.webapp.exceptions;

public class UserFileNotFound extends Exception {
    public UserFileNotFound() {
        super();
    }

    public UserFileNotFound(String message) {
        super(message);
    }
}
