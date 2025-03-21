package org.example.commands;

import org.example.managers.DumpManager;
import org.example.utility.Engine;

import java.io.IOException;

/**
 * Класс - команда для сохранения коллекции в файл
 */
public class Save extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public Save(int wordsCount,Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("save : сохранить коллекцию в файл 'Lab5_data'");
    }

    /**
     *
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
    @Override
    public void execute(String[] splitedConsoleRead) {
        try {
            DumpManager.writeCollection(this.engine.getCollectionManager());
            System.out.println("Коллекция записана в файл!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "save";
    }
}
