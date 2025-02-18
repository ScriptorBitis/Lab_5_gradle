package models.creators;

import models.Event;
import exeptions.ExitWhileExecuting;
import exeptions.WrongInput;
import utility.Engine;

import java.util.Scanner;

public class EventCreator extends Creator {
    private static Scanner consoleRead = new Scanner(System.in);

    public static Event createEvent() throws WrongInput {
        Event event=null;
        Event.Builder builder = new Event.Builder();


        System.out.println("Инициализировано создание ивента");

        System.out.print("Вы хотите создать описание мероприятия?\n1 : да\n2 : нет\n->");

        boolean pass= true;
        do {

            try {


                switch (Integer.valueOf(consoleRead.nextLine())) {
                    case (1):
                        builder.name(askName());
                        builder.ticketsCount(askTicketCount());
                        builder.description(askDescription());

                        event = builder.build();
                        pass = false;
                        break;
                    case (2):
                        event = null;
                        pass = false;
                        break;

                    default:
                        pass = true;
                        System.out.println("Ошибка ввода.\nВыберите одно из двухъ значений");
                        break;


                }
            }catch (NumberFormatException exception){
                System.out.println("Ошибка ввода: выберите одно из двух значений");
            }

        }while (pass);


        return event;

    }
    private static String askName(){
        boolean pass = true;
        String name;
        do {
            System.out.print("Введите значение для параметра 'name'\n->");
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
    private  static int askTicketCount(){
        System.out.print("Введите количество билетов->");
        int ticketCount=0;
        boolean pass=true;
        do{
        try {
            String userRequest=consoleRead.nextLine().trim();
            if (userRequest.equals("exit")){
                Engine.finishProgramm();
                throw new ExitWhileExecuting("Введена команда exit во время ввода количества билетов");
            }
            ticketCount=Integer.valueOf(userRequest);

            if (ticketCount <= 0) {
                throw new WrongInput("Количество билетов отрицательное");
            }
            pass=false;
        } catch (NumberFormatException | WrongInput exception) {
            System.out.println("Ошибка: введено неправильное значение.\nЗначение должно быть больше 0");

        }
        }while (pass);
        return ticketCount;
    }
    private static String askDescription(){
        String description;
        boolean pass=true;
        System.out.print("Введите описание мероприятия.Ввод пустой строки будет засчитан как отсутствие описания\n->");
        description=consoleRead.nextLine().trim();
        if (description.equals("exit")){
            Engine.finishProgramm();
            throw new ExitWhileExecuting("Введена команда exit во время ввода описания");
        }
        if (description.isEmpty()){
            return null;
        }
        else {
            return description;
        }

    }


}
