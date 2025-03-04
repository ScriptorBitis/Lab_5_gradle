package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.exeptions.NoSuchTypeException;
import org.example.models.Ticket;
import org.example.models.TicketType;
import org.example.utility.Engine;

import java.util.HashMap;
import java.util.Map;

public class RemoveAnyByType extends Command implements Executable {

    private Engine engine;

    public RemoveAnyByType(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        validateCommand(splitedConsoleRead);
        String type = splitedConsoleRead[1];
        if (type.equals("VIP") || type.equals("BUDGETARY") || !type.equals("CHEAP")) {
            throw new NoSuchTypeException("Команда remove_any_by_type состоит из 2 слов : команда и типа билета('VIP','BUDGETARY','CHEAP')");
        }
        TicketType ticketType;
        Map<String, TicketType> ticketsTypes = new HashMap<>();
        ticketsTypes.put("VIP", TicketType.VIP);
        ticketsTypes.put("BUDGETARY", TicketType.BUDGETARY);
        ticketsTypes.put("CHEAP", TicketType.CHEAP);
        ticketType = ticketsTypes.get(type);
        for (String key : this.engine.getCollectionManager().getCollection().keySet()) {
            Ticket ticket = this.engine.getCollectionManager().getCollection().get(key);
            if (ticket.getType().equals(ticketType)) {
                System.out.println("Удаление объекта " + this.engine.getCollectionManager().getCollection().get(key).toString());
                this.engine.getCollectionManager().getCollection().remove(key);
                return;
            }
        }
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException {
        if (splitedConsoleRead.length != this.getWordsCount()) {
            throw new InvalidArgumentsException("Команда remove_any_by_type состоит из 2 слов : команда и типа билета('VIP','BUDGETARY','CHEAP')");
        }
    }

    @Override
    public String toString() {
        return "remove_any_by_type";
    }

    @Override
    public void describe() {
        System.out.println("remove_any_by_type type : удалить из коллекции один элемент, значение поля type которого эквивалентно заданному");
    }
}
