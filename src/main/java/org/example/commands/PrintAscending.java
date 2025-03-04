package org.example.commands;

import org.example.models.Ticket;
import org.example.utility.Engine;
import java.util.*;

public class PrintAscending extends Command implements Executable {

    private Engine engine;

    public PrintAscending(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        Map<String, Ticket> COLLECTION = this.engine.getCollectionManager().getCollection();
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
