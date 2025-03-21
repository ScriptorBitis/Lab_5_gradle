package org.example.exeptions;

/**
 * Исключение, которое выбрасывается при отсутствии введенного ключа у коллекции {@link java.util.Map}
 */
public class NoKeyException extends RuntimeException {
    public NoKeyException(String message) {
        super(message);
    }
}
