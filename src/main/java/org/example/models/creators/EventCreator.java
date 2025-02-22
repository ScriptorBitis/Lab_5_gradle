package org.example.models.creators;

import org.example.models.Event;
import org.example.exeptions.WrongFieldValueExeption;
import org.example.utility.console.Console;
import org.example.utility.console.StandartConsole;

import java.util.Scanner;

// builder.name(askName());
//        builder.ticketsCount(askTicketCount());
//        builder.description(askDescription());
//event = builder.build();
public class EventCreator extends Creator {

    private static Console console = new StandartConsole(new Scanner(System.in));

    public static Event createEvent() throws WrongFieldValueExeption {
        Event event = null;
        Event.Builder builder = new Event.Builder();
        System.out.println("Инициализировано создание ивента");

        boolean pass = true;
        while (pass) {
            System.out.print("Вы хотите создать описание мероприятия?\n1 : да\n2 : нет\n->");
            switch (console.getUserInputString()) {
                case ("1"):
                    builder.name(askName());
                    builder.ticketsCount(askTicketCount());
                    builder.description(askDescription());
                    event = builder.build();
                    pass = false;
                    break;
                case ("2"):
                    event = null;
                    pass = false;
                    break;
            }
        }
        return event;
    }


    private static String askName() {
        String name = null;
        while (name == null || name.equals("")) {
            System.out.print("Введите значение для параметра 'name'.Оно не может быть пустым\n->");
            name = console.getUserInputString();
        }
        return name;
    }

    private static int askTicketCount() {
        System.out.print("Введите количество билетов->");
        int ticketCount = 0;
        boolean pass = true;
        while (pass) {
            try {
                String userRequest = console.getUserInputString();
                ticketCount = Integer.valueOf(userRequest);
                if (ticketCount <= 0) {
                    throw new WrongFieldValueExeption("Количество билетов отрицательное");
                }
                pass = false;
            } catch (NumberFormatException | WrongFieldValueExeption exception) {
                System.out.println("Ошибка: введено неправильное значение.\nЗначение должно быть числом > 0");
            }
        }
        return ticketCount;
    }

    private static String askDescription() {
        String description;
        System.out.print("Введите описание мероприятия.Ввод пустой строки будет засчитан как отсутствие описания\n->");
        description = console.getUserInputString();
        if (description.isEmpty()) {
            return null;
        }
        return description;
    }
}
