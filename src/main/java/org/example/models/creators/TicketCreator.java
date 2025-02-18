package models.creators;


import models.Ticket;
import models.TicketType;
import exeptions.ExitWhileExecuting;
import exeptions.WrongInput;
import utility.Engine;

import java.util.Scanner;

public class TicketCreator extends Creator {
    private static Scanner consoleRead = new Scanner(System.in);

    public static Ticket createTicket(String message) throws WrongInput {


        System.out.println(message);
        Ticket.Builder builder = new Ticket.Builder();
        try {
            builder.name(askName());
            builder.price(askPrice());
            builder.discount(askDiscount());
            builder.refundable(askRefundable());
            builder.type(askTicketType());
            builder.coordinates(CoordinatesCreator.createCoordinates());
            builder.event(EventCreator.createEvent());
        }catch (ExitWhileExecuting exitWhileBuilding){
            System.out.println(exitWhileBuilding.getMessage());
        }
        Ticket element = builder.build();

        return element;
    }

    private static String askName() {

        boolean pass = true;
        String name;
        do {
            System.out.print("Введите значение для параметра 'name' ->");

            name = consoleRead.nextLine().trim();
            if (name.equals("exit")){
                Engine.finishProgramm();
                throw new ExitWhileExecuting("Введена команда exit во время ввода имени");
            }
            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустым!");

            } else {
                pass = false;
            }

        } while (pass);
        return name;
    }

    private static Integer askPrice() {

        System.out.print("Введите значение для параметра 'price'.Ввод пустой строки будет засчитан за отсутствие параметра.\nВас предупредили\n->");
        Integer integer = 0;
        Boolean pass = true;
        do {

            try {
                String userRequest = consoleRead.nextLine().trim();
                if (userRequest.equals("exit")){
                    Engine.finishProgramm();
                    throw new ExitWhileExecuting("Введена команда exit во время ввода цены");
                }
                if (userRequest.isEmpty()) {
                    integer = null;
                } else {
                    integer = Integer.valueOf(userRequest);
                    if (integer <= 0) {
                        throw new WrongInput("Значение цены не натуральное, а отрицательное");
                    }
                }


                pass = false;
            } catch (NumberFormatException | WrongInput exception) {
                System.out.println(exception.toString());
                System.out.println("Ошибка: введено неправильное значение.\nPrice соответствует число без букв и пробелов >0. Повторите ввод");

            }

        } while (pass);
        return integer;
    }

    private static float askDiscount() {

        System.out.print("Введите значение для параметра 'скидка' > 0 и <= 100\nПример ввода: 15.5\n->");
        float discount = 0;
        Boolean pass = true;
        do {

            try {
                String userRequest=consoleRead.nextLine().trim();


                if (userRequest.equals("exit")){
                    Engine.finishProgramm();
                    throw new ExitWhileExecuting("Введена команда exit во время ввода скидки");
                }
                discount = Float.valueOf(userRequest);

                if (discount <= 0 || discount > 100) {
                    throw new WrongInput("Введено неправильное значения параметра 'скидка");
                }
                pass = false;
            } catch (NumberFormatException | WrongInput exception) {
                System.out.println("Ошибка: введено неправильное значение.\nСкидке соответствует число без букв и пробелов. Повторите ввод");

            }
        } while (pass);

        return discount;

    }

    private static Boolean askRefundable() {

        Boolean refundable=null;
        Boolean pass = true;
        System.out.print("Введите значение для параметра 'refundable'\nВыберите соответствующее значение\n1 : да, билет вернуть можно\n2 : нет, вернуть билет нельзя\n3 : не вводить параметр\n4 : прервать создание объекта\n->");
        do {
            try {


                switch (Integer.valueOf(consoleRead.nextLine().trim())) {
                    case (1):
                        refundable = true;
                        pass = false;
                        break;
                    case (2):
                        refundable = false;
                        pass = false;
                        break;
                    case (3):
                        refundable = null;
                        pass = false;
                        break;
                    case (4):
                        Engine.finishProgramm();
                        throw new ExitWhileExecuting("Введена команда exit во время ввода Enum`а");


                    default:

                        System.out.println("Ошибка ввода\nВыберите одно из двух значений.Введите '1' ,или '2', или '3'");
                        break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода\nВыберите одно из двух значений.Введите '1' ,или '2', или '3'");
            }
        } while (pass);
        return refundable;

    }

    private static TicketType askTicketType() {
        System.out.print("Выберите значение для параметра 'type':\n1 : VIP\n2 : BUDGETARY\n3 : CHEAP\n4 : не вводить параметр\n5 : прервать создание объекта\n(необходимо ввести цифру)\n->");
        TicketType ticketType = null;
        Boolean pass = true;
        do {
            try {
                switch (Integer.valueOf(consoleRead.nextLine().trim())) {
                    case (1):
                        ticketType = TicketType.VIP;
                        pass = false;
                        break;
                    case (2):
                        ticketType = TicketType.BUDGETARY;
                        pass = false;
                        break;
                    case (3):
                        ticketType = TicketType.CHEAP;
                        pass = false;
                        break;
                    case (4):
                        ticketType = null;
                        pass = false;
                        break;
                    case (5):
                        Engine.finishProgramm();
                        throw new ExitWhileExecuting("Введена команда exit во время ввода Enum`а");
                    default:
                        System.out.println("Ошибка ввода\nВыберите одно из предоставленных значений");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода\nВыберите одно из предоставленных значений");

            }
        } while (pass);
        return ticketType;
    }

}
