package org.example.commands;

import org.example.utility.Engine;

/**
 * Класс-команда для завершения программы
 */
public class Exit extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public Exit(int wordsCount ,Engine engine) {
        super(wordsCount);
        this.engine = engine;

    }

    /**
     *
     * @param splitedRequest ввод необходимых аргументов с консоли
     */
    @Override
    public void execute(String[] splitedRequest) {
        this.engine.finishProgramm();
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "exit";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("exit : завершить программу (без сохранения в файл)");
    }


}
