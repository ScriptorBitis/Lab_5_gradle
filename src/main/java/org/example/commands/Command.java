package org.example.commands;


import org.example.managers.CollectionManager;
import org.example.utility.Engine;

public abstract class Command {
    protected CollectionManager collectionManager;
    protected Engine engine;
    protected int wordsCount;

    public Command(int wordsCount, CollectionManager collectionManager) {
        this.wordsCount = wordsCount;
        this.collectionManager = collectionManager;
    }

    public Command(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public Command(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Command() {
    }

    public Command(int wordsCount, CollectionManager collectionManager, Engine engine) {
        this.wordsCount = wordsCount;
        this.collectionManager = collectionManager;
        this.engine = engine;
    }

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public Engine getEngine() {
        return engine;
    }
}
