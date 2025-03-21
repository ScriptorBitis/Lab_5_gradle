package org.example.commands;

import org.example.utility.Engine;

/**
 * Класс-команда для вывода всех доступных команд
 */
public class Help extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public Help(int wordsCount,Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedRequest) {
        for (Executable executable : this.engine.getCommandManager().getCommands().values()) {
            executable.describe();
        }
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "help";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("Help : вывести описание каждой доступной пользователю команды");
    }
}
