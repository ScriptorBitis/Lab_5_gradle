package org.example.models.creators;


import org.example.exeptions.WrongFieldValueException;
import org.example.models.Ticket;
import org.example.models.TicketType;
import org.example.utility.console.Console;
import org.example.utility.console.StandartConsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicketCreator {
    private static final Console console = new StandartConsole(new Scanner(System.in));

    public static Ticket createTicket(String message) throws WrongFieldValueException {

        System.out.println(message);
        Ticket.Builder builder = new Ticket.Builder();
        builder.name(askName());
        builder.price(askPrice());
        builder.discount(askDiscount());
        builder.refundable(askRefundable());
        builder.type(askTicketType());
        builder.coordinates(CoordinatesCreator.createCoordinates());
        builder.event(EventCreator.createEvent());
        Ticket element = builder.build();
        return element;
    }

    private static String askName() {
        String name = null;
        while (name == null || name.isBlank()) {
            name = console.getUserInputString("Введите значение для параметра 'name'.Оно не может быть пустым\n->");
        }
        return name;
    }

    private static Integer askPrice() {
        Integer price = 0;
        boolean correctField = true;
        while (correctField) {
            try {
                price = console.getUserInputIntMayBeNull("Введите значение для параметра 'price'.Ввод пустой строки будет засчитан за отсутствие параметра.\nВас предупредили\n->");
                if (price == null) {
                    return price;
                }
                if (price <= 0) {
                    throw new WrongFieldValueException("Значение цены не натуральное, а отрицательное");
                }
                correctField = false;
            } catch (WrongFieldValueException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return price;
    }

    private static float askDiscount() {
        float discount = 0;
        boolean correctField = true;
        while (correctField) {
            try {
                discount = console.getUserInputFloat("Введите значение для параметра 'скидка' > 0 и <= 100\nПример ввода: 15.5\n->");
                if (discount <= 0 || discount > 100) {
                    throw new WrongFieldValueException("Введено неправильное значения параметра 'скидка");
                }
                correctField = false;
            } catch (WrongFieldValueException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return discount;
    }

    private static Boolean askRefundable() {
        Boolean refundable = null;
        Map<String, Boolean> refundableMap = new HashMap<>();
        refundableMap.put("1", true);
        refundableMap.put("2", false);
        String userRequest;
        while (refundable == null) {
            userRequest = console.getUserInputString("Введите значение для параметра 'refundable'\nВыберите соответствующее значение\n1 : да, билет вернуть можно\n2 : нет, вернуть билет нельзя\nВвод пустой строки будет принят как пустое значение\n->");
            if (userRequest.isEmpty()) {
                break;
            }
            refundable = refundableMap.get(userRequest);
        }
        return refundable;
    }

    private static TicketType askTicketType() {
        TicketType ticketType = null;
        Map<String, TicketType> ticketsTypes = new HashMap<>();
        ticketsTypes.put("1", TicketType.VIP);
        ticketsTypes.put("2", TicketType.BUDGETARY);
        ticketsTypes.put("3", TicketType.CHEAP);
        String userRequest;
        while (ticketType == null) {
            userRequest = console.getUserInputString("Выберите значение для параметра 'type':\n1 : VIP\n2 : BUDGETARY\n3 : CHEAP\nВвод пустой строки будет принят как пустое значение\n->");
            if (userRequest.isEmpty()) {
                break;
            }
            ticketType = ticketsTypes.get(userRequest);
        }
        return ticketType;
    }
}
