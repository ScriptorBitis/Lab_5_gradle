package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;

import java.util.ArrayList;
import java.util.List;

public class RemoveLower extends Command implements Executable {
    public RemoveLower(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        Ticket ticket = TicketCreator.createTicket("Инициализировано создание билета для поиска и удаления билетов, цена которых больше");
        List<String> keyList = new ArrayList<>();
        for (String key : getCollectionManager().getCollection().keySet()) {
            Ticket ticketFromCollection = getCollectionManager().getCollection().get(key);
            if (ticketFromCollection.getPrice() < ticket.getPrice()) {
                keyList.add(key);
            }
        }
        for (String key : keyList) {
            getCollectionManager().getCollection().remove(key);
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
