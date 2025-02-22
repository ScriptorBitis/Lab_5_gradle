package org.example.models.creators;


import org.example.models.Ticket;
import org.example.models.TicketType;
import org.example.exeptions.WrongFieldValueExeption;
import org.example.utility.console.Console;
import org.example.utility.console.StandartConsole;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicketCreator extends Creator {
    private static Console console=new StandartConsole(new Scanner(System.in));

    public static Ticket createTicket(String message) throws WrongFieldValueExeption {

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
        String name=null;
        while (name==null || name.equals("")){
            System.out.print("Введите значение для параметра 'name'.Оно не может быть пустым\n->");
            name=console.getUserInputString();
        }
        return name;
    }

    private static Integer askPrice() {

        System.out.print("Введите значение для параметра 'price'.Ввод пустой строки будет засчитан за отсутствие параметра.\nВас предупредили\n->");
        Integer price = 0;
        boolean pass = true;
        while (pass){
            try {
                String userRequest = console.getUserInputString();
                if (userRequest.isEmpty()) {
                    price = null;
                } else {
                    price = Integer.valueOf(userRequest);
                    if (price <= 0) {
                        throw new WrongFieldValueExeption("Значение цены не натуральное, а отрицательное");
                    }
                }
                pass = false;
            } catch (NumberFormatException | WrongFieldValueExeption exception) {
                System.out.println("Ошибка: введено неправильное значение.\nPrice соответствует число без букв и пробелов >0. Повторите ввод");
            }
        }
        return price;
    }

    private static float askDiscount() {
        System.out.print("Введите значение для параметра 'скидка' > 0 и <= 100\nПример ввода: 15.5\n->");
        float discount = 0;
        boolean pass = true;
        while (pass) {
            try {
                String userRequest = console.getUserInputString();
                discount = Float.valueOf(userRequest);
                if (discount <= 0 || discount > 100) {
                    throw new WrongFieldValueExeption("Введено неправильное значения параметра 'скидка");
                }
                pass = false;
            } catch (NumberFormatException | WrongFieldValueExeption exception) {
                System.out.println("Ошибка: введено неправильное значение.\nСкидке соответствует число без букв и пробелов. Повторите ввод");
            }
        }
        return discount;
    }

    private static Boolean askRefundable() {
        Boolean refundable = null;
        Map<String,Boolean> refundableMap=new HashMap<>();
        refundableMap.put("1",true);
        refundableMap.put("2",false);
        String userRequest;
        while (refundable==null){
            System.out.print("Введите значение для параметра 'refundable'\nВыберите соответствующее значение\n1 : да, билет вернуть можно\n2 : нет, вернуть билет нельзя\nВвод пустой строки будет принят как пустое значение\n->");
            userRequest=console.getUserInputString();
            if(userRequest.isEmpty()){
                break;
            }
            refundable=refundableMap.get(console.getUserInputString());
        }
        return refundable;
    }

    private static TicketType askTicketType() {
        TicketType ticketType = null;
        Map<String,TicketType> ticketsTypes=new HashMap<>();
        ticketsTypes.put("1",TicketType.VIP);
        ticketsTypes.put("2",TicketType.BUDGETARY);
        ticketsTypes.put("3",TicketType.CHEAP);
        String userRequest;
        while (ticketType==null) {
            System.out.print("Выберите значение для параметра 'type':\n1 : VIP\n2 : BUDGETARY\n3 : CHEAP\nВвод пустой строки будет принят как пустое значение\n->");
            userRequest=console.getUserInputString();
            if(userRequest.isEmpty()){
                break;
            }
            ticketType=ticketsTypes.get(console.getUserInputString());
        }
        return ticketType;
    }
}
