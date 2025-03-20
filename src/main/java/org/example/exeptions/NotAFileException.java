package org.example.exeptions;

/**
 * Исключение, которое выбрасывается, когда путь не ведет к файлу
 */

public class NotAFileException extends RuntimeException {
    public NotAFileException(String message) {
        super(message);
    }
}
