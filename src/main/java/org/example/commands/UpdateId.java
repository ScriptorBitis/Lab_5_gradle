package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.exeptions.WrongIdInputException;
import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.managers.CollectionManager;

import java.util.Map;

public class UpdateId extends Command implements Executable {

    public UpdateId(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public UpdateId(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public UpdateId(int wordsCount) {
        super(wordsCount);
    }

    public UpdateId() {
    }

    @Override
    public void execute(String[] splitedConsoleRead) {

        int id=0;
        try {
            id = Integer.valueOf(splitedConsoleRead[1]);
        } catch (NumberFormatException e) {
            System.out.println("id введен неверно.id - число");
        }

        Map<String, Ticket> collection = this.collectionManager.getCollection();
        for (String key : collection.keySet()) {
            if (collection.get(key).getId()==id) {
                collection.replace(key,TicketCreator.createTicket("Создание билета для замены по id"));

            }
        }
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
