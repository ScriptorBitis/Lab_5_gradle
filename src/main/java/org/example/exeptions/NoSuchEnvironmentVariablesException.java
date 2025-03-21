package org.example.exeptions;

/**
 * Исключение, которые выбрасывается при отсутствии переменной окружения
 */
public class NoSuchEnvironmentVariablesException extends RuntimeException {
    public NoSuchEnvironmentVariablesException(String message) {
        super(message);
    }
}
