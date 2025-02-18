package org.example.models.creators;

import org.example.models.Coordinates;
import org.example.exeptions.ExitWhileExecuting;
import org.example.exeptions.WrongInput;
import org.example.utility.Engine;

import java.util.Scanner;

public class CoordinatesCreator extends Creator {

    private static Scanner consoleRead = new Scanner(System.in);

    public static Coordinates createCoordinates() throws WrongInput {

        Coordinates.Builder builder = new Coordinates.Builder();


        System.out.println("Инициализировано задание координат");

        builder.x(askX());
        builder.y(askY());
        Coordinates coordinates = builder.build();
        return coordinates;
    }

    private static int askX() {
        System.out.print("Введите координату x\n->");
        int x = 0;
        boolean pass = true;
        do {
            try {
                String userRequest = consoleRead.nextLine().trim();
                if (userRequest.equals("exit")) {
                    Engine.finishProgramm();
                    throw new ExitWhileExecuting("Введена команда exit во время ввода координаты x");
                }
                x = Integer.valueOf(userRequest);


                pass = false;
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода.Попробуйте снова");
            }
        } while (pass);
        return x;
    }


    private static Double askY() {
        System.out.print("Введите координату y. Учтите, что значение Y не может быть больше 484\n->");
        Double y = 0.0;
        boolean pass = true;
        do {
            try {
                String userRequest = consoleRead.nextLine().trim();
                if (userRequest.equals("exit")) {
                    Engine.finishProgramm();
                    throw new ExitWhileExecuting("Создание объекта прервано:\nВведена команда exit во время ввода координаты Y");
                }
                y = Double.valueOf(userRequest);
                if (y > 484) {
                    throw new WrongInput("y превышает максимальное значение");
                }
                pass = false;
            } catch (NumberFormatException | WrongInput exception) {
                System.out.println("Ошибка ввода.Попробуйте снова");

            }

        } while (pass);

        return y;
    }


}
