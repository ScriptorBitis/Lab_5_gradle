package org.example.exeptions;

/**
 * Исключение, которое выбрасывается при некорректных аргументах, необходимый для команды
 */
public class InvalidArgumentsException extends RuntimeException {
    public InvalidArgumentsException(String message) {
        super(message);
    }
}
