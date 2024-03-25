package com.example.exception;

public class GroceryItemNotAvailableException extends Exception {

    public GroceryItemNotAvailableException(String message) {
        super(message);
    }
}
