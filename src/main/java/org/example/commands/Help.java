package org.example.commands;

import org.example.utility.Engine;

public class Help extends Command implements Executable {
    private Engine engine;

    public Help(int wordsCount,Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedRequest) {
        for (Executable executable : this.engine.getCommandManager().getCommands().values()) {
            executable.describe();
        }
    }

    @Override
    public String toString() {
        return "help";
    }

    @Override
    public void describe() {
        System.out.println("Help : вывести описание каждой доступной пользователю команды");
    }
}
