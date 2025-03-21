package org.example.commands;

import org.example.models.Ticket;
import org.example.utility.Engine;

import java.util.*;

/**
 * Класс - команда для вывода команд в порядке возрастания
 */
public class PrintAscending extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public PrintAscending(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine = engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        Map<String, Ticket> COLLECTION = this.engine.getCollectionManager().getCollection();
        List<Ticket> ticketByPrice = new ArrayList<>(COLLECTION.values());
        Collections.sort(ticketByPrice, (ticket1, ticket2) -> ticket1.getPrice() - ticket2.getPrice());
        for (Ticket ticket : ticketByPrice) {
            System.out.println(ticket.toString());
        }
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "print_ascending";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("print_ascending : вывести элементы коллекции в порядке возрастания");
    }
}
