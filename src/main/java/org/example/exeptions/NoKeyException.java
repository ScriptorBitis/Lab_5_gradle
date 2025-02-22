package org.example.exeptions;

public class NoKeyException extends RuntimeException {
    public NoKeyException(String message) {
        super(message);
    }
}
