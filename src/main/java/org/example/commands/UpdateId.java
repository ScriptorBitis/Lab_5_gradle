package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.utility.Engine;

import java.security.Key;
import java.util.Map;

/**
 * класс - команда для обновления билета с заданным Id
 */
public class UpdateId extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public UpdateId(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine = engine;
    }

    /**
     *
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
    @Override
    public void execute(String[] splitedConsoleRead) {
        int id = 0;
        this.validateCommand(splitedConsoleRead);
        try {
            id = Integer.valueOf(splitedConsoleRead[1]);
        } catch (NumberFormatException e) {
            System.out.println("id введен неверно.id - число");
        }

        Map<String, Ticket> collection = this.engine.getCollectionManager().getCollection();
        String key = this.engine.getCollectionManager().findKeyById(id);
        if (key==null){
            return;
        }
        collection.replace(key, TicketCreator.createTicket("Создание билета для замены по id"));
    }

    /**
     * Валидация команды
     * @param splitedConsoleRead -ввод с консоли
     * @throws InvalidArgumentsException
     */
    @Override
    public void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException {
        if (splitedConsoleRead.length != this.getWordsCount()) {
            throw new InvalidArgumentsException("Команда update состоит из команды и ключа .");
        }
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "update";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
    }
}
