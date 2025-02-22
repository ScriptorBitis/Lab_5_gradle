package org.example.exeptions;

public class WrongFieldValueExeption extends RuntimeException {
    public WrongFieldValueExeption(String message) {
        super(message);
    }
}
