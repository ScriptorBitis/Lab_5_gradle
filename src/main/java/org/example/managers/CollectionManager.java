package org.example.managers;

import org.example.models.Ticket;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Класс, отвечающий за хранение коллекции, информации о ней и работу с коллекцией
 */
public class CollectionManager {

    private final LocalDateTime initializationDate;
    private Map<String, Ticket> collection;

    /**
     * Конструктор
     * @param ticketMap - передается Map`а, такое тз...
     */
    public CollectionManager(Map<String, Ticket> ticketMap) {
        this.collection = ticketMap;
        this.initializationDate = LocalDateTime.now().withNano(0);
    }

    /**
     * Сортировка коллекции с помощью {@link Comparator}
     * Вывод {@link Ticket} по ворзростанию цены
     * @return
     */
    public Map<String, Ticket> sortByPrice() {
        List<Ticket> ticketByPrice = new ArrayList<>(this.collection.values());
        Collections.sort(ticketByPrice, Comparator.comparing(Ticket::getPrice));
        for (Ticket ticket : ticketByPrice) {
            System.out.println(ticket.toString());
        }
        return Map.of();
    }

    /**
     * Метод, отвечающий за поиск ключа объекта по id
     * @param id -поле {@link Ticket}
     * @return ключ коллекции {@link CollectionManager#collection}
     */
    public String findKeyById(int id) {
        for (String key : this.collection.keySet()) {
            if (this.collection.get(key).getId() == id) {
                return key;
            }
        }
        System.out.println("Объекта с id = " + id + " не существует!");
        return null;
    }

    /**
     *
     * @return {@link CollectionManager#collection}
     */
    public Map<String, Ticket> getCollection() {
        return collection;
    }

    /**
     * назначить коллекцию
     * @param collection {@link Map}
     */
    public void setCollection(Map<String, Ticket> collection) {
        this.collection = collection;
    }

    /**
     * Получить поле {@link CollectionManager#initializationDate}
     * @return
     */
    public LocalDateTime getInitializationDate() {
        return initializationDate;
    }

    /**
     * Добавить объект в коллекцию {@link CollectionManager#collection}
     * @param key ключ для {@link Map}
     * @param ticket объект класса {@link Ticket}
     */
    public void addTicket(String key, Ticket ticket) {
        this.collection.put(key, ticket);
    }


}
