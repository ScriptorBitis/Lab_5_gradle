package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.models.Ticket;
import org.example.models.creators.*;
import org.example.utility.Validatable;

public class Insert extends Command implements Executable {

    public Insert(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public Insert(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public Insert(int wordsCount) {
        super(wordsCount);
    }

    public Insert() {
    }

    @Override
    public void execute(String[] splitedRequest) {

        if (splitedRequest.length != this.getWordsCount()) {
            System.out.println("Команда execute состоит из 2 слов : команда и ключ");
                return;
        }


        Ticket ticket = TicketCreator.createTicket("Инициализировано создание билета");

        if (ticket.validate()) {
            this.collectionManager.addTicket(splitedRequest[1], ticket);
            System.out.println("Элемент успешно добавлен в коллекцию!");
        } else {
            System.out.println("Какой-то параметр введен неверно!Элемент не будет добавлен в коллекцию");
        }

    }


    @Override
    public String toString() {
        return "insert";
    }
    @Override
    public void describe() {
        System.out.println("insert null {element} : добавить новый элемент с заданным ключом");
    }

}
