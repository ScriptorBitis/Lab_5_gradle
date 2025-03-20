package org.example.exeptions;

/**
 * Исключение, которое выбрасывается при введении неверного значения id ( такого не существует и etc)
 */
public class WrongIdInputException extends RuntimeException {
    public WrongIdInputException(String message) {
        super(message);
    }
}
