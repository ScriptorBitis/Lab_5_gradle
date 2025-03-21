package org.example.exeptions;

/**
 * Исключение, которое выбрасывается при отсутствии переменной окружения
 */
public class NoSuchEnvironmentVariablesException extends RuntimeException {
    public NoSuchEnvironmentVariablesException(String message) {
        super(message);
    }
}
