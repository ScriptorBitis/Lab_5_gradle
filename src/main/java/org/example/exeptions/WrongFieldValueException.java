package org.example.exeptions;

public class WrongFieldValueException extends RuntimeException {
    public WrongFieldValueException(String message) {
        super(message);
    }
}
