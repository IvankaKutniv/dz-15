package com.itproger.lesson_15.homework.exceptions;

public class WrongAccountException extends Exception {

    public WrongAccountException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "WrongAccountException{}";
    }
}
