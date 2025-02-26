package org.example.exeptions;

public class NotFileException extends RuntimeException {
    public NotFileException(String message) {
        super(message);
    }
}
