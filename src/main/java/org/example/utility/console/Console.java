package org.example.utility.console;

import org.example.exeptions.InterraptExitException;

/**
 * интерфейс для получения определенных значений из потока ввода
 */
public interface Console {
    /**
     * @param message сообщение, которое будет передано пользователю
     * @return
     * @throws InterraptExitException если в ввод поступила команда exit
     */
    String getUserInputString(String message) throws InterraptExitException;

    /**
     *
     * @param message сообщение, которое будет передано пользователю
     * @return
     */
    int getUserInputInt(String message);

    /**
     * MayBeNull-значение может быть null`ом
     * @param message сообщение, которое будет передано пользователю
     * @return
     */
    Integer getUserInputIntMayBeNull(String message);

    /**
     *
     * @param message сообщение, которое будет передано пользователю
     * @return
     */
    double getUserInputDouble(String message);

    /**
     *
     * @param message сообщение, которое будет передано пользователю
     * @return
     */
    float getUserInputFloat(String message);
}
