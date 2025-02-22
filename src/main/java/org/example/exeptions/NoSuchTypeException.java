package org.example.exeptions;

public class NoSuchTypeException extends RuntimeException {
    public NoSuchTypeException(String message) {
        super(message);
    }
}
