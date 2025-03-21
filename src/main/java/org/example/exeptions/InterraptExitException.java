package org.example.exeptions;

/**
 * Исключение, которое выбрасывается во время ввода 'exit' в консоль в самых неожиданных моментах...
 */
public class InterraptExitException extends RuntimeException {
    public InterraptExitException(String message) {
        super(message);
    }

}
