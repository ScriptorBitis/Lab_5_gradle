package org.example.commands;


import org.example.managers.CollectionManager;

public class Info extends Command implements Executable{

    public Info(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public Info(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public Info(int wordsCount) {
        super(wordsCount);
    }

    public Info() {
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        System.out.println("Информация о коллекции:\n"+
                "Количество элементов : "+ this.collectionManager.getCollection().size()+"\n"+
                "Тип : " + this.collectionManager.getCollection().getClass().getSimpleName()+"\n"+
                "Время инициализации : "+ this.collectionManager.getInitializationDate()+"\n"+
                "Набор доступных ключей : "+ this.collectionManager.getCollection().keySet()
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
