package org.example.commands;


import org.example.managers.CollectionManager;
import org.example.utility.Engine;


public class Exit extends Command implements Executable{

    public Exit(int wordsCount, CollectionManager collectionManager, Engine engine) {
        super(wordsCount, collectionManager, engine);
    }

    @Override
    public void execute(String[] splitedRequest) {
        engine.finishProgramm();
    }

    @Override
    public String toString() {
        return "exit";
    }

    @Override
    public void describe() {
        System.out.println("exit : завершить программу (без сохранения в файл)");
    }


}
