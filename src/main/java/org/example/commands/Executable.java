package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.exeptions.NoKeyException;
import org.example.exeptions.WrongIdInputException;

/**
 * Интерфейс, имплементируемый классами, способными выполнять какие-то команды
 */
public interface Executable {

    /**
     * Выполнить предназначенную судьбой инструкцию
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
    default void execute(String[] splitedConsoleRead)  {
        System.out.println("Команда выполнена?");
    }

    /**
     * Описать, что делает команда
     */
    void describe();

    /**
     * Валидация аргументов, поступивших в комманду
     * @param splitedConsoleRead -ввод с консоли
     * @throws InvalidArgumentsException надеюсь, что все из названия понятно
     */
    default void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException {
        System.out.println("Проверка пройдена?");
    }
}
