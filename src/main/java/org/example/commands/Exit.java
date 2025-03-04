package org.example.commands;

import org.example.utility.Engine;

public class Exit extends Command implements Executable {
    private Engine engine;

    public Exit(int wordsCount ,Engine engine) {
        super(wordsCount);
        this.engine = engine;

    }

    @Override
    public void execute(String[] splitedRequest) {
        this.engine.finishProgramm();
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
