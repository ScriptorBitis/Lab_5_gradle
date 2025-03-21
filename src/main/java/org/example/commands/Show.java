package org.example.commands;

import org.example.utility.Engine;

/**
 * Класс - команда для вывода элементов коллекции
 */
public class Show extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public Show(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    /**
     *
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
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

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "show";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
