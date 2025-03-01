package org.example.commands;

import org.example.managers.CollectionManager;


public class Clear extends Command implements Executable {

    public Clear(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        if (this.collectionManager.getCollection().isEmpty()) {
            System.out.println("Коллекция пуста!");
        } else {
            this.collectionManager.getCollection().clear();
            System.out.println("Коллекция успешно очищена!");
        }

    }

    @Override
    public String toString() {
        return "clear";
    }

    @Override
    public void describe() {
        System.out.println("clear : очистить коллекцию");
    }
}
