package com.itproger.lesson_15.homework.exceptions;

public class WrongCurrencyException extends Exception {

    public WrongCurrencyException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "WrongCurrencyException{}";
    }
}
