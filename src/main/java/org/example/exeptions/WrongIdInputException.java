package org.example.exeptions;

public class WrongIdInputException extends RuntimeException {
    public WrongIdInputException(String message) {
        super(message);
    }
}
