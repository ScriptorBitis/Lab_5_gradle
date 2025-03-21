package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.exeptions.NoSuchTypeException;
import org.example.models.Ticket;
import org.example.models.TicketType;
import org.example.utility.Engine;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс - команда для удаления элементов коллекцию по типу {@link TicketType}
 */
public class RemoveAnyByType extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public RemoveAnyByType(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine=engine;
    }

    /**
     *
     * @param splitedConsoleRead ввод необходимых аргументов с консоли
     */
    @Override
    public void execute(String[] splitedConsoleRead) {
        validateCommand(splitedConsoleRead);
        String type = splitedConsoleRead[1];
        if (type.equals("VIP") || type.equals("BUDGETARY") || !type.equals("CHEAP")) {
            throw new NoSuchTypeException("Команда remove_any_by_type состоит из 2 слов : команда и типа билета('VIP','BUDGETARY','CHEAP')");
        }
        TicketType ticketType;
        Map<String, TicketType> ticketsTypes = new HashMap<>();
        ticketsTypes.put("VIP", TicketType.VIP);
        ticketsTypes.put("BUDGETARY", TicketType.BUDGETARY);
        ticketsTypes.put("CHEAP", TicketType.CHEAP);
        ticketType = ticketsTypes.get(type);
        for (String key : this.engine.getCollectionManager().getCollection().keySet()) {
            Ticket ticket = this.engine.getCollectionManager().getCollection().get(key);
            if (ticket.getType().equals(ticketType)) {
                System.out.println("Удаление объекта " + this.engine.getCollectionManager().getCollection().get(key).toString());
                this.engine.getCollectionManager().getCollection().remove(key);
                return;
            }
        }
    }

    /**
     * Валидация аргументов
     * @param splitedConsoleRead -ввод с консоли
     * @throws InvalidArgumentsException
     */
    @Override
    public void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException {
        if (splitedConsoleRead.length != this.getWordsCount()) {
            throw new InvalidArgumentsException("Команда remove_any_by_type состоит из 2 слов : команда и типа билета('VIP','BUDGETARY','CHEAP')");
        }
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "remove_any_by_type";
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("remove_any_by_type type : удалить из коллекции один элемент, значение поля type которого эквивалентно заданному");
    }
}
