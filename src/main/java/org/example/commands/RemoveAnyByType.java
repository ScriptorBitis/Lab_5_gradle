package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.models.Ticket;
import org.example.models.TicketType;
import org.example.utility.Engine;

public class RemoveAnyByType extends Command implements Executable {
    public RemoveAnyByType(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public RemoveAnyByType(int wordsCount) {
        super(wordsCount);
    }

    public RemoveAnyByType(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public RemoveAnyByType() {
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        if (splitedConsoleRead.length != this.getWordsCount()) {
            System.out.println("Команда remove_by_any состоит из 2 слов : команда и типа билета('VIP','BUDGETARY','CHEAP')");
            return;
        }
        String type=splitedConsoleRead[1];
        TicketType ticketType;
        switch (type){
            case ("VIP"):
                ticketType=TicketType.VIP;
                break;
            case ("BUDGETARY"):
                ticketType=TicketType.BUDGETARY;
                break;
            case ("CHEAP"):
                ticketType=TicketType.CHEAP;
                break;
            default:
                System.out.println("Тип билета не распозан. Введите одно из доступных значений: 'VIP','BUDGETARY','CHEAP' ");
                return;

        }
        for (String key:getCollectionManager().getCollection().keySet()){
            Ticket ticket=getCollectionManager().getCollection().get(key);
            if (ticket.getType().equals(ticketType)){
                System.out.println("Удаление объекта "+getCollectionManager().getCollection().get(key).toString());
                getCollectionManager().getCollection().remove(key);
                return;

            }

        }
    }

    @Override
    public String toString() {
        return "remove_any_by_type";
    }

    @Override
    public void describe() {
        System.out.println("remove_any_by_type type : удалить из коллекции один элемент, значение поля type которого эквивалентно заданному");
    }
}
