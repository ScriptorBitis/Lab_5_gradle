package org.example.commands;

import org.example.utility.Engine;

import java.util.Map;

/**
 * Класс-команда для очистки содержимого коллекции
 */
public class Clear extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public Clear(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    /**
     * Вызов метода {@link Map#clear()}
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
    @Override
    public void execute(String[] splitedConsoleRead) {
        if (this.engine.getCollectionManager().getCollection().isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        this.engine.getCollectionManager().getCollection().clear();
        System.out.println("Коллекция успешно очищена!");
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "clear";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("clear : очистить коллекцию");
    }
}
