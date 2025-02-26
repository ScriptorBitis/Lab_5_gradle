package org.example.exeptions;

public class NoSuchEnvironmentVariablesException extends RuntimeException {
    public NoSuchEnvironmentVariablesException(String message) {
        super(message);
    }
}
