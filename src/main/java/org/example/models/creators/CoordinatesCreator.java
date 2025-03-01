package org.example.models.creators;

import org.example.exeptions.WrongFieldValueException;
import org.example.models.Coordinates;
import org.example.utility.console.Console;
import org.example.utility.console.StandartConsole;

import java.util.Scanner;

public class CoordinatesCreator {
    private static final Console console = new StandartConsole(new Scanner(System.in));

    public static Coordinates createCoordinates() throws WrongFieldValueException {
        Coordinates.Builder builder = new Coordinates.Builder();
        System.out.println("Инициализировано задание координат");
        builder.x(askX());
        builder.y(askY());
        Coordinates coordinates = builder.build();
        return coordinates;
    }

    private static int askX() {
        int x;
        x = console.getUserInputInt("Введите координату x\n->");
        return x;
    }


    private static Double askY() {
        Double y = 0.0;
        boolean correctField = true;
        while (correctField) {
            try {
                y = console.getUserInputDouble("Введите координату y. Учтите, что значение Y не может быть больше 484\n->");
                if (y > 484) {
                    throw new WrongFieldValueException("y превышает максимальное значение");
                }
                correctField = false;
            } catch (WrongFieldValueException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return y;
    }
}
