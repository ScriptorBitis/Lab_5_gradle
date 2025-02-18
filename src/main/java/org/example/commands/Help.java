package commands;

import managers.CollectionManager;
import managers.CommandManager;

public class Help extends Command implements Executable{

    public Help(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public Help(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public Help(int wordsCount) {
        super(wordsCount);
    }

    public Help() {
    }

    @Override
    public void execute(String[] splitedRequest) {
        //System.out.println(helpMessage);
        for (Executable executable: CommandManager.getCommands().values()){
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
