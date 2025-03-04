package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.utility.Engine;

import java.security.Key;
import java.util.Map;

public class UpdateId extends Command implements Executable {

    private Engine engine;

    public UpdateId(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine = engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        int id = 0;
        this.validateCommand(splitedConsoleRead);
        try {
            id = Integer.valueOf(splitedConsoleRead[1]);
        } catch (NumberFormatException e) {
            System.out.println("id введен неверно.id - число");
        }

        Map<String, Ticket> collection = this.engine.getCollectionManager().getCollection();
        String key = this.engine.getCollectionManager().findKeyById(id);
        if (key==null){
            return;
        }
        collection.replace(key, TicketCreator.createTicket("Создание билета для замены по id"));
    }


    @Override
    public void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException {
        if (splitedConsoleRead.length != this.getWordsCount()) {
            throw new InvalidArgumentsException("Команда update состоит из команды и ключа .");
        }
    }


    @Override
    public String toString() {
        return "update";
    }

    @Override
    public void describe() {
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
    }
}
