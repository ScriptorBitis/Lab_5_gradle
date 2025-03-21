package org.example.commands;

import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.utility.Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс - команда для удаления из коллекции все элементы, превышающий заданный
 */
public class RemoveGreater extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public RemoveGreater(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine =engine;
    }

    /**
     *
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
    @Override
    public void execute(String[] splitedConsoleRead) {
        Ticket ticket = TicketCreator.createTicket("Инициализировано создание билета для поиска и удаления билетов, цена которых больше");
        List<String> keyList = new ArrayList<>();
        for (String key : this.engine.getCollectionManager().getCollection().keySet()) {
            Ticket ticketFromCollection = this.engine.getCollectionManager().getCollection().get(key);
            if (ticketFromCollection.getPrice() > ticket.getPrice()) {
                keyList.add(key);
            }
        }
        for (String key : keyList) {
            this.engine.getCollectionManager().getCollection().remove(key);
            System.out.println("Удален билет по ключу " + key);
        }
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "remove_greater";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("remove_greater {element} : удалить из коллекции все элементы, превышающие заданный");
    }
}
