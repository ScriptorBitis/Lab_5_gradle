package org.example.commands;

import org.example.utility.Engine;

public class Info extends Command implements Executable {
    private Engine engine;

    public Info(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        System.out.println("\u001B[32m"+"Информация о коллекции:\n" +
                "Количество элементов : " + this.engine.getCollectionManager().getCollection().size() + "\n" +
                "Тип : " +this.engine.getCollectionManager().getCollection().getClass().getSimpleName() + "\n" +
                "Время инициализации : " + this.engine.getCollectionManager().getInitializationDate() + "\n" +
                "Набор доступных ключей : " + this.engine.getCollectionManager().getCollection().keySet()+
                "\u001B[0m"
        );
    }

    @Override
    public String toString() {
        return "info";
    }

    @Override
    public void describe() {
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции");
    }
}
