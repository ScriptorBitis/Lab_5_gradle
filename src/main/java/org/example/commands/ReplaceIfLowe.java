package org.example.commands;

import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.utility.Engine;

public class ReplaceIfLowe extends Command implements Executable {

    private Engine engine;

    public ReplaceIfLowe(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        if (!this.engine.getCollectionManager().getCollection().containsKey(splitedConsoleRead[1])) {
            System.out.println("Такого ключа нет! Ознакомьтесь с доступными ключами, введя 'info'");
            return;
        }
        Ticket ticket = TicketCreator.createTicket("Создание билета для сравнения !цены! и возможной последующей замены");
        if (this.engine.getCollectionManager().getCollection().get(splitedConsoleRead[1]).getPrice() > ticket.getPrice()) {
            this.engine.getCollectionManager().getCollection().replace(splitedConsoleRead[1], ticket);
            System.out.println("Билет заменен!");
            return;
        }
        System.out.println("Билет не был заменет : новое значение цены не меньше старого.");
    }

    @Override
    public String toString() {
        return "replace_if_lowe";
    }

    @Override
    public void describe() {
        System.out.println("replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого");
    }
}
