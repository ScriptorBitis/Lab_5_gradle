package org.example.commands;

public abstract class Command {
    protected int wordsCount;

    public Command(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public Command() {
    }

    public int getWordsCount() {
        return wordsCount;
    }

}
