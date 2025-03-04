package org.example.commands;

import org.example.utility.Engine;

public class Clear extends Command implements Executable {

    private Engine engine;

    public Clear(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        if (this.engine.getCollectionManager().getCollection().isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        this.engine.getCollectionManager().getCollection().clear();
        System.out.println("Коллекция успешно очищена!");
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
