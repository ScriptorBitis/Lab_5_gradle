package org.example.managers;

import org.example.models.Ticket;

import java.time.LocalDateTime;
import java.util.*;


public class CollectionManager {

    private final LocalDateTime initializationDate;
    private Map<String, Ticket> collection;

    public CollectionManager(Map<String, Ticket> ticketMap) {
        this.collection = ticketMap;
        this.initializationDate = LocalDateTime.now().withNano(0);
    }

    public Map<String, Ticket> sortByPrice() {
        List<Ticket> ticketByPrice = new ArrayList<>(this.collection.values());
        Collections.sort(ticketByPrice, Comparator.comparing(Ticket::getPrice));
        for (Ticket ticket : ticketByPrice) {
            System.out.println(ticket.toString());
        }
        return Map.of();
    }

    public String findKeyById(int id) {
        for (String key : this.collection.keySet()) {
            if (this.collection.get(key).getId() == id) {
                return key;
            }
        }
        System.out.println("Объекта с id = " + id + " не существует!");
        return null;
    }

    public Map<String, Ticket> getCollection() {
        return collection;
    }

    public void setCollection(Map<String, Ticket> collection) {
        this.collection = collection;
    }

    public LocalDateTime getInitializationDate() {
        return initializationDate;
    }

    public void addTicket(String key, Ticket ticket) {
        this.collection.put(key, ticket);
    }


}
