package org.example.commands;

import org.example.managers.DumpManager;
import org.example.utility.Engine;

import java.io.IOException;

public class Save extends Command implements Executable {

    private Engine engine;

    public Save(int wordsCount,Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void describe() {
        System.out.println("save : сохранить коллекцию в файл 'Lab5_data'");
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        try {
            DumpManager.writeCollection(this.engine.getCollectionManager());
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
