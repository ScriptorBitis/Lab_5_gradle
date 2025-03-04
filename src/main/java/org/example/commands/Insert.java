package org.example.commands;

import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.utility.Engine;

public class Insert extends Command implements Executable {

    private Engine engine;

    public Insert(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedRequest) {
        if (splitedRequest.length != this.getWordsCount()) {
            System.out.println("Команда execute состоит из 2 слов : команда и ключ");
            return;
        }
        Ticket ticket = TicketCreator.createTicket("Инициализировано создание билета");
        if (ticket.validate()) {
            this.engine.getCollectionManager().addTicket(splitedRequest[1], ticket);
            System.out.println("Элемент успешно добавлен в коллекцию!");
            return;
        }
        System.out.println("Какой-то параметр введен неверно!Элемент не будет добавлен в коллекцию");
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
