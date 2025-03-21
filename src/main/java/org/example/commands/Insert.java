package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.utility.Engine;

/**
 * Класс - команда для добавления новых элементов в коллекцию
 */
public class Insert extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public Insert(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    /**
     * @param splitedRequest ввод необходимых аргументов с консоли
     */
    @Override
    public void execute(String[] splitedRequest) {
        validateCommand(splitedRequest);

        Ticket ticket = TicketCreator.createTicket("Инициализировано создание билета");
        if (ticket.validate()) {
            this.engine.getCollectionManager().addTicket(splitedRequest[1], ticket);
            System.out.println("Элемент успешно добавлен в коллекцию!");
            return;
        }
        System.out.println("Какой-то параметр введен неверно!Элемент не будет добавлен в коллекцию");
    }

    /**
     * Валидация аргументов
     * @param splitedConsoleRead -ввод с консоли
     * @throws InvalidArgumentsException
     */
    @Override
    public void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException {
        if (splitedConsoleRead.length != this.getWordsCount()) {
           throw new InvalidArgumentsException("Команда insert состоит из двух слов : название команды и будущего ключа элемента");
        }

    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "insert";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("insert null {element} : добавить новый элемент с заданным ключом");
    }

}
