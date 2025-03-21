package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.utility.Engine;

/**
 * Удалить элемент коллекции по ключу
 */
public class RemoveKey extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public RemoveKey(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine = engine;
    }

    /**
     *
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
    @Override
    public void execute(String[] splitedConsoleRead) {
        validateCommand(splitedConsoleRead);
        if (this.engine.getCollectionManager().getCollection().containsKey(splitedConsoleRead[1])) {
            this.engine.getCollectionManager().getCollection().remove(splitedConsoleRead[1]);
            System.out.println("Элемент удален!");
            return;
        }
        System.out.println("Такого ключа нет! Можете ознакомиться с доступными ключами, введя info");
    }

    /**
     * Валидация команды
     * @param splitedConsoleRead -ввод с консоли
     * @throws InvalidArgumentsException
     */
    @Override
    public void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException {
        if (splitedConsoleRead.length != this.getWordsCount()) {
            throw new InvalidArgumentsException("Команда remove_key состоит из команды и ключа\nВозвращение на домашнюю страницу.");
        }
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "remove_key";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("remove_key null : удалить элемент из коллекции по его ключу");
    }
}
