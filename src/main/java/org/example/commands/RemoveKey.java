package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.utility.Engine;

public class RemoveKey extends Command implements Executable {

    private Engine engine;

    public RemoveKey(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine = engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        validateCommand(splitedConsoleRead);
        if (this.engine.getCollectionManager().getCollection().containsKey(splitedConsoleRead[1])) {
            this.engine.getCollectionManager().getCollection().remove(splitedConsoleRead[1]);
            System.out.println("Элемент удален!");
            return;
        }
        System.out.println("Такого ключа нет! Можете ознакомиться с доступными ключами, введя info");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException {
        if (splitedConsoleRead.length != this.getWordsCount()) {
            throw new InvalidArgumentsException("Команда remove_key состоит из команды и ключа\nВозвращение на домашнюю страницу.");
        }
    }

    @Override
    public String toString() {
        return "remove_key";
    }

    @Override
    public void describe() {
        System.out.println("remove_key null : удалить элемент из коллекции по его ключу");
    }
}
