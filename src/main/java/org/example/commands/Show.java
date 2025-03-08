package org.example.commands;

import org.example.utility.Engine;

public class Show extends Command implements Executable {

    private Engine engine;

    public Show(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        if (this.engine.getCollectionManager().getCollection().isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        for (String key : this.engine.getCollectionManager().getCollection().keySet()) {
            System.out.println("\u001B[34m"+"Ключ : " + key + "\u001B[0m" +"\u001B[32m"+". Элемент : " + this.engine.getCollectionManager().getCollection().get(key)+"\u001B[0m");
        }
    }

    @Override
    public String toString() {
        return "show";
    }

    @Override
    public void describe() {
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
