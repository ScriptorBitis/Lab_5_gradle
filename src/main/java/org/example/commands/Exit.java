package org.example.commands;


import org.example.managers.CollectionManager;
import static org.example.utility.Engine.finishProgramm;

public class Exit extends Command implements Executable{

    public Exit(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public Exit(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public Exit(int wordsCount) {
        super(wordsCount);
    }

    public Exit() {
    }

    @Override
    public void execute(String[] splitedRequest) {
        finishProgramm();
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
