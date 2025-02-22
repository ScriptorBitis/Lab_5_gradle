package org.example.commands;

import org.example.models.Ticket;
import org.example.managers.CollectionManager;

public class Show extends Command implements Executable{

    public Show(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public Show(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public Show(int wordsCount) {
        super(wordsCount);
    }

    public Show() {
    }

    @Override
    public void execute(String[] splitedConsoleRead) {

        if (this.collectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пуста!");
            return;
        }

        for (String key :this.collectionManager.getCollection().keySet()){
            System.out.println("Ключ : " + key + ". Элемент : "+this.collectionManager.getCollection().get(key) );

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
