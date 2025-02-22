package org.example.models.creators;

import org.example.models.Event;
import org.example.exeptions.WrongFieldValueException;
import org.example.utility.console.Console;
import org.example.utility.console.StandartConsole;

import java.util.Scanner;

public class EventCreator extends Creator {

    private static Console console = new StandartConsole(new Scanner(System.in));

    public static Event createEvent() throws WrongFieldValueException {
        Event event = null;
        Event.Builder builder = new Event.Builder();
        System.out.println("Инициализировано создание ивента");

        boolean pass = true;
        while (pass) {
            switch (console.getUserInputString("Вы хотите создать описание мероприятия?\n1 : да\n2 : нет\n->")) {
                case ("1"):
                    builder.name(askName());
                    builder.ticketsCount(askTicketCount());
                    builder.description(askDescription());
                    event = builder.build();
                    pass = false;
                    break;
                case ("2"):
                    return null;
            }
        }
        return event;
    }


    private static String askName() {
        String name = null;
        while (name == null || name.equals("")) {
            name = console.getUserInputString("Введите значение для параметра 'name'.Оно не может быть пустым\n->");
        }
        return name;
    }

    private static int askTicketCount() {
        int ticketCount = 0;
        boolean pass = true;
        while (pass) {
            try {
                String userRequest = console.getUserInputString("Введите количество билетов->");
                ticketCount = Integer.valueOf(userRequest);
                if (ticketCount <= 0) {
                    throw new WrongFieldValueException("Количество билетов отрицательное");
                }
                pass = false;
            } catch ( WrongFieldValueException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return ticketCount;
    }

    private static String askDescription() {
        String description;
        description = console.getUserInputString("Введите описание мероприятия.Ввод пустой строки будет засчитан как отсутствие описания\n->");
        if (description.isEmpty()) {
            return null;
        }
        return description;
    }
}
