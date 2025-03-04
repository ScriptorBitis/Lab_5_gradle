package org.example.models;

import java.util.Map;

public class IdGenerator {
    private static Integer TicketIdCounter = 0;
    private static Integer EventIdCounter = 0;

    public static Integer getTicketIdCounter() {
        return TicketIdCounter;
    }

    public static Integer getEventIdCounter() {
        return EventIdCounter;
    }

    private static void setTicketIdCounter(Integer idCounter) {
        TicketIdCounter = idCounter;
    }

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

    public static int assigntTicketId() {
        TicketIdCounter++;
        return TicketIdCounter;
    }

    private static void setEventIdCounter(Integer idCounter) {
        EventIdCounter = idCounter;
    }

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

    public static int assigntEventIdCounter() {
        EventIdCounter++;
        return EventIdCounter;
    }
}
