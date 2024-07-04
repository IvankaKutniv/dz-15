package com.itproger.lesson_15.homework.exceptions;

public class WrongOperationException extends Exception {

    public WrongOperationException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "WrongOperationException{}";
    }
}
