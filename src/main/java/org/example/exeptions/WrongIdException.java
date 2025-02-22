package org.example.exeptions;

public class WrongIdException extends RuntimeException {
    public WrongIdException(String message) {
        super(message);
    }
}
