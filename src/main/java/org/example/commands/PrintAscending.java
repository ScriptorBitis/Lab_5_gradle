package org.example.commands;

import org.example.models.Ticket;
import org.example.managers.CollectionManager;

import java.util.*;

public class PrintAscending  extends Command implements Executable{

    public PrintAscending(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public PrintAscending(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public PrintAscending(int wordsCount) {
        super(wordsCount);
    }

    public PrintAscending() {
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        Map<String,Ticket> COLLECTION = this.collectionManager.getCollection();
        List<Ticket> ticketByPrice = new ArrayList<>(COLLECTION.values());
        Collections.sort(ticketByPrice, Comparator.comparing(Ticket::getPrice));

        for (Ticket ticket : ticketByPrice) {
            System.out.println(ticket.toString());
        }
    }

    @Override
    public String toString() {
        return "print_ascending";
    }

    @Override
    public void describe() {
        System.out.println("print_ascending : вывести элементы коллекции в порядке возрастания");
    }
}
