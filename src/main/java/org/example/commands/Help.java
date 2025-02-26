package org.example.commands;


import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;
import org.example.utility.Engine;

public class Help extends Command implements Executable{


    public Help(int wordsCount, CollectionManager collectionManager, Engine engine) {
        super(wordsCount, collectionManager, engine);
    }

    @Override
    public void execute(String[] splitedRequest) {
        for (Executable executable: this.getEngine().getCommandManager().getCommands().values()){
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
