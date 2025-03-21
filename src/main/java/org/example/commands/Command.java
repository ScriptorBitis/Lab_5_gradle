package org.example.commands;

/**
 * Абстрактный класс. Начало всех команд
 */
public abstract class Command {
    /**
     * Количество слов ( аргументы + сама команда )
     */
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
