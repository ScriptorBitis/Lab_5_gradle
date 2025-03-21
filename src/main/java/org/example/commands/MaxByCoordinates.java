package org.example.commands;

import org.example.models.Ticket;
import org.example.utility.Engine;

/**
 * Класс-команда для вывода элемента коллекции с наибольшими координатами
 */
public class MaxByCoordinates extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public MaxByCoordinates(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    /**
     *
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
    @Override
    public void execute(String[] splitedConsoleRead) {
        Ticket ticket = null;
        double coordinatesSum = Double.MIN_VALUE;
        for (Ticket ticket1 : this.engine.getCollectionManager().getCollection().values()) {
            if (Math.pow(ticket1.getCoordinates().getX(), 2) + Math.pow(ticket1.getCoordinates().getY(), 2) > coordinatesSum) {
                coordinatesSum = Math.pow(ticket1.getCoordinates().getX(), 2) + Math.pow(ticket1.getCoordinates().getY(), 2);
                ticket = ticket1;
            }
        }
        System.out.println(ticket.toString());
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "max_by_coordinates";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("max_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является максимальным");
    }
}
