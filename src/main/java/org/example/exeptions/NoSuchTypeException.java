package org.example.exeptions;

/**
 * Исключение, которое выбрасывается, когда вводится тип {@link org.example.models.Ticket}, которого не существует
 */
public class NoSuchTypeException extends RuntimeException {
    public NoSuchTypeException(String message) {
        super(message);
    }
}
