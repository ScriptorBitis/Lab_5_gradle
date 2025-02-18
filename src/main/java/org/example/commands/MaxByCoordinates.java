package org.example.commands;


import org.example.managers.CollectionManager;
import org.example.models.*;

public class MaxByCoordinates extends Command implements Executable {

    public MaxByCoordinates(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public MaxByCoordinates(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public MaxByCoordinates(int wordsCount) {
        super(wordsCount);
    }

    public MaxByCoordinates() {
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        Ticket ticket=null;
        double coordinatesSum=Double.MIN_VALUE;
        for (Ticket ticket1:this.collectionManager.getCollection().values()){
            if (Math.pow(ticket1.getCoordinates().getX(),2)+Math.pow(ticket1.getCoordinates().getY(),2)>coordinatesSum){
                coordinatesSum=Math.pow(ticket1.getCoordinates().getX(),2)+Math.pow(ticket1.getCoordinates().getY(),2);
                ticket=ticket1;
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
