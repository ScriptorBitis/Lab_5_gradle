package org.example.commands;

import org.example.exeptions.NoKeyException;
import org.example.managers.CollectionManager;

public class RemoveKey extends Command implements Executable {

    public RemoveKey(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public RemoveKey(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public RemoveKey(int wordsCount) {
        super(wordsCount);
    }

    public RemoveKey() {
    }

    @Override
    public void execute(String[] splitedConsoleRead) {


        if (splitedConsoleRead.length!=this.getWordsCount()){
            throw new NoKeyException("Команда remove_key состоит из команды и ключа\nВозвращение на домашнюю страницу.");
        }


        if (this.collectionManager.getCollection().containsKey(splitedConsoleRead[1])){
            this.collectionManager.getCollection().remove(splitedConsoleRead[1]);
            System.out.println("Элемент удален!");

        }else {
            System.out.println("Такого ключа нет! Можете ознакомиться с доступными ключами, введя info");
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
