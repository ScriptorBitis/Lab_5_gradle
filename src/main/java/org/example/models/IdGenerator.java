package org.example.models;

import java.util.List;
import java.util.Map;

public class IdGenerator {
    static private Integer TicketIdCounter=0;
    static private Integer EventIdCounter=0;



    private static void setTicketIdCounter(Integer idCounter) {
        TicketIdCounter = idCounter;
    }

    public static void restoreTicketIdCounter(Map<String, Ticket> ticketMap) {
        if (ticketMap.isEmpty()){
            setTicketIdCounter(0);
            return;
        }

        for (Ticket ticket: ticketMap.values()){
            if (ticket.getId()> TicketIdCounter){
                setTicketIdCounter(ticket.getId());
            }
        }
    }

    public static int assigntTicketId() {
        TicketIdCounter++;
        return TicketIdCounter;
    }

    private static void setEventIdCounter(Integer idCounter) {
        TicketIdCounter = idCounter;
    }

    public static void restoreEventIdCounter(Map<String, Ticket> ticketMap) {
        if (ticketMap.isEmpty()){
            setEventIdCounter(0);
            return;
        }

        for (Ticket ticket: ticketMap.values()){
            if (ticket.getEvent()==null){
                continue;
            }
            if (ticket.getEvent().getId()> EventIdCounter){
                setEventIdCounter(ticket.getEvent().getId());
            }
        }
    }

    public static int assigntEventIdCounter() {
        EventIdCounter++;
        return EventIdCounter;
    }
}
