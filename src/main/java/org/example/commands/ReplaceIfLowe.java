package org.example.commands;

import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.utility.Engine;

/**
 * Класс - команда, чтобы заменить объект в случае, если созданный меньше
 */
public class ReplaceIfLowe extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
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

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "replace_if_lowe";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого");
    }
}
