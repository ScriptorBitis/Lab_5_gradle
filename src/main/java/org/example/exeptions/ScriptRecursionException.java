package org.example.exeptions;

/**
 * Исключение, которое выбрасывается при обнаружении рекурсии
 */
public class ScriptRecursionException extends RuntimeException {
    public ScriptRecursionException(String message) {
        super(message);
    }
}
