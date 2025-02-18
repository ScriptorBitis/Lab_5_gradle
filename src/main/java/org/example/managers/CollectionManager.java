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
            /*
            Map<String, Person> people = new HashMap<>();
        Person jim = new Person("Jim", 25);
        Person scott = new Person("Scott", 28);
        Person anna = new Person("Anna", 23);

        people.put(jim.getName(), jim);
        people.put(scott.getName(), scott);
        people.put(anna.getName(), anna);

        // not yet sorted
        List<Person> peopleByAge = new ArrayList<>(people.values());

        Collections.sort(peopleByAge, Comparator.comparing(Person::getAge));

        for (Person p : peopleByAge) {
            System.out.println(p.getName() + "\t" + p.getAge());
        }
             */
}
