package org.example.commands;

import org.example.models.Ticket;
import org.example.utility.Engine;

public class MaxByCoordinates extends Command implements Executable {
    private Engine engine;

    public MaxByCoordinates(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

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

    @Override
    public String toString() {
        return "max_by_coordinates";
    }

    @Override
    public void describe() {
        System.out.println("max_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является максимальным");
    }
}
