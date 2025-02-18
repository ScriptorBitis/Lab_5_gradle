package org.example.commands;

public interface Executable {
    default void execute(String[] splitedConsoleRead){
        System.out.println("Команда выполнена?");
    }
    void describe();



}
