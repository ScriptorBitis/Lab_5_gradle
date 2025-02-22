package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.managers.DumpManager;

import java.io.IOException;

public class Save extends Command implements Executable{
    public Save(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public Save(int wordsCount) {
        super(wordsCount);
    }

    public Save(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public Save() {
    }

    @Override
    public void describe() {
        System.out.println("save : сохранить коллекцию в файл 'Lab5_data'");

    }

    @Override
    public void execute(String[] splitedConsoleRead) {

        try {
            DumpManager.writeCollection(collectionManager);
            System.out.println("Коллекция записана в файл!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "save";
    }
}
