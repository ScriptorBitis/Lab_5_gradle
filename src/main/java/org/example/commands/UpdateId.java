package org.example.commands;

import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.managers.CollectionManager;

import java.util.Map;

public class UpdateId extends Command implements Executable{

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

        if (splitedConsoleRead.length != this.getWordsCount()) {
            System.out.println("Команда update состоит из команды и ключа .\nВозвращение на домашнюю страницу.");
            return;
        }

        int id;
        Map<String,Ticket> COLLECTION = this.collectionManager.getCOLLECTION();
        try { id=Integer.valueOf(splitedConsoleRead[1]);
            for (Ticket ticket: COLLECTION.values()){
                if (ticket.getId()==id){
                   for (String key: COLLECTION.keySet()){
                       if (ticket.equals(COLLECTION.get(key))){
                           this.collectionManager.addTicket(key, TicketCreator.createTicket("Для обновление элемента коллеции надо ввести параметры."));
                           System.out.println("Элемент с id "+id+" обновлен");
                       }
                   }
                    return;
                }
                System.out.println("Элемента с id "+id+" не существует!");
            }
        }catch (NumberFormatException exception){
            System.out.println("id должен быть числом\nВозвращение на главное страницу");
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
