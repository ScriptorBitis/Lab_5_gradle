package org.example.models.creators;

import org.example.models.Coordinates;
import org.example.exeptions.WrongFieldValueExeption;
import org.example.utility.console.Console;
import org.example.utility.console.StandartConsole;

import java.util.Scanner;

public class CoordinatesCreator extends Creator {
    private static Console console=new StandartConsole(new Scanner(System.in));

    public static Coordinates createCoordinates() throws WrongFieldValueExeption {
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
        while (pass) {
            try {
                String userRequest = console.getUserInputString();
                x = Integer.valueOf(userRequest);
                pass = false;
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода.Попробуйте снова");
            }
        }
        return x;
    }


    private static Double askY() {
        System.out.print("Введите координату y. Учтите, что значение Y не может быть больше 484\n->");
        Double y = 0.0;
        boolean pass = true;
        while (pass){
            try {
                String userRequest = console.getUserInputString();
                y = Double.valueOf(userRequest);
                if (y > 484) {
                    throw new WrongFieldValueExeption("y превышает максимальное значение");
                }
                pass = false;
            } catch (NumberFormatException | WrongFieldValueExeption exception) {
                System.out.println("Ошибка ввода.Попробуйте снова");
            }
        }
        return y;
    }
}
