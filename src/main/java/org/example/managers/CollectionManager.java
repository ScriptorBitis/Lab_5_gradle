package org.example.managers;



import org.example.models.Ticket;

import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager {

    private  Map<String, Ticket> collection ;
    private final LocalDateTime initializationDate ;

    public CollectionManager(Map<String, Ticket> ticketMap) {
        this.collection=ticketMap;
        this.initializationDate=LocalDateTime.now().withNano(0);
    }

    public Map<String, Ticket> getCollection() {
        return collection;
    }

    public LocalDateTime getInitializationDate() {
        return initializationDate;
    }

    public void setCollection(Map<String, Ticket> collection) {
        this.collection = collection;
    }

    public  void addTicket(String key, Ticket ticket) {
        this.collection.put(key, ticket);
    }

    public static Map<String, Ticket> sortByPrice(Map<String, Ticket> COLLECTION) {
        List<Ticket> ticketByPrice = new ArrayList<>(COLLECTION.values());
        Collections.sort(ticketByPrice, Comparator.comparing(Ticket::getPrice));

        for (Ticket ticket : ticketByPrice) {
            System.out.println(ticket.toString());
        }

        return Map.of();
    }

}
