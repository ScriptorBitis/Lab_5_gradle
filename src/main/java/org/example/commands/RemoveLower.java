package org.example.commands;

import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.utility.Engine;

import java.util.ArrayList;
import java.util.List;

public class RemoveLower extends Command implements Executable {

    private Engine engine;

    public RemoveLower(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        Ticket ticket = TicketCreator.createTicket("Инициализировано создание билета для поиска и удаления билетов, цена которых больше");
        List<String> keyList = new ArrayList<>();
        for (String key : this.engine.getCollectionManager().getCollection().keySet()) {
            Ticket ticketFromCollection = this.engine.getCollectionManager().getCollection().get(key);
            if (ticketFromCollection.getPrice() < ticket.getPrice()) {
                keyList.add(key);
            }
        }
        for (String key : keyList) {
            this.engine.getCollectionManager().getCollection().remove(key);
            System.out.println("Удален билет по ключу " + key);
        }
    }

    @Override
    public String toString() {
        return "remove_lower";
    }

    @Override
    public void describe() {
        System.out.println("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный");
    }

}
