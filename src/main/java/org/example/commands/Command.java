package commands;

import managers.CollectionManager;

public abstract class Command {
    int wordsCount;
    CollectionManager collectionManager;

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

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public int getWordsCount() {
        return wordsCount;
    }

}
