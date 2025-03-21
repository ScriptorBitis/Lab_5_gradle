package org.example.exeptions;

/**
 * Исключение, которое выбрасывается при некорректном поле у объектов
 */
public class WrongFieldValueException extends RuntimeException {
    public WrongFieldValueException(String message) {
        super(message);
    }
}
