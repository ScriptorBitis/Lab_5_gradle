package org.example.utility;

/**
 * интерфейс, применяемый к объектам, которые могут быть проверены на корректность полей
 */
public interface Validatable {
    /**
     * Корректный ли объект
     * @return значение true/false
     */
    boolean validate();
}
