package org.example.commands;

import org.example.utility.Engine;

/**
 * Класс - команда для вывода информации о коллекции
 */
public class Info extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public Info(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    /**
     *  Вывод информации о коллекции
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
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

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "info";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции");
    }
}
