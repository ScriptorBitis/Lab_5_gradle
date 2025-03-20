package org.example.models;

import java.util.Map;

/**
 * Класс для восстановления последовательности id у {@link Ticket} и {@link Event}
 */
public class IdGenerator {
    private static Integer TicketIdCounter = 0;
    private static Integer EventIdCounter = 0;

    /**
     * назначить id для {@link Ticket}
     * @param idCounter id
     */
    private static void setTicketIdCounter(Integer idCounter) {
        TicketIdCounter = idCounter;
    }

    /**
     * Востановить значение (т.е. привести его в состояние, при котором не возникнет коллизии id`шников  {@link IdGenerator#TicketIdCounter}
     * @param ticketMap Коллекция билетов
     */
    public static void restoreTicketIdCounter(Map<String, Ticket> ticketMap) {
        if (ticketMap.isEmpty()) {
            setTicketIdCounter(0);
            return;
        }
        for (Ticket ticket : ticketMap.values()) {
            if (ticket.getId() > TicketIdCounter) {
                setTicketIdCounter(ticket.getId());
            }
        }
    }

    /**
     * При создании выдать id для {@link Ticket}
     * @return id
     */
    public static int assigntTicketId() {
        TicketIdCounter++;
        return TicketIdCounter;
    }

    /**
     * назначить id для {@link Event}
     * @param idCounter id
     */
    private static void setEventIdCounter(Integer idCounter) {
        EventIdCounter = idCounter;
    }

    /**
     * Востановить значение (т.е. привести его в состояние, при котором не возникнет коллизии id`шников  {@link IdGenerator#EventIdCounter}
     * @param ticketMap Коллекция билетов
     */
    public static void restoreEventIdCounter(Map<String, Ticket> ticketMap) {
        if (ticketMap.isEmpty()) {
            setEventIdCounter(0);
            return;
        }
        for (Ticket ticket : ticketMap.values()) {
            if (ticket.getEvent() == null) {
                continue;
            }
            if (ticket.getEvent().getId() > EventIdCounter) {
                setEventIdCounter(ticket.getEvent().getId());
            }
        }
    }
    /**
     * При создании выдать id для {@link Event}
     * @return id
     */
    public static int assigntEventIdCounter() {
        EventIdCounter++;
        return EventIdCounter;
    }
}
