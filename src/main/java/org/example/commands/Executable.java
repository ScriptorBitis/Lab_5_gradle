package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.exeptions.NoKeyException;
import org.example.exeptions.WrongIdInputException;

public interface Executable {
    default void execute(String[] splitedConsoleRead) throws NoKeyException, WrongIdInputException {
        System.out.println("Команда выполнена?");
    }

    void describe();

    default void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException {
        System.out.println("Проверка пройдена?");
    }


}
