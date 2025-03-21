package org.example.utility.console;

import org.example.exeptions.InterraptExitException;
import java.util.Scanner;

/**
 * Класс, необходимый для ввода определенных значений
 */
public class StandartConsole implements Console {
    private final Scanner scanner;

    public StandartConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     *
     * @param message сообщение, которое будет передано пользователю
     * @return String, который проверяется на ввод команды 'exit'
     */
    @Override
    public String getUserInputString(String message) {
        System.out.print(message);
        return getUserInputCheckExit();
    }

    /**
     * Пользователь будет вводить int, пока число не будет введено
     * @param message сообщение, которое будет передано пользователю
     * @return int
     */
    @Override
    public int getUserInputInt(String message) {
        int integer = 0;
        boolean intInput = true;
        while (intInput) {
            try {
                System.out.print(message);
                integer = Integer.valueOf(getUserInputCheckExit());
                intInput = false;
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }
        return integer;
    }

    /**
     *
     * @param message сообщение, которое будет передано пользователю
     * @return Integer, где ввод пустой строки считается за null
     */
    @Override
    public Integer getUserInputIntMayBeNull(String message) {
        Integer integer = null;
        boolean intInput = true;
        while (intInput) {
            try {
                System.out.print(message);
                String userInput = getUserInputCheckExit();
                if (userInput.isEmpty()) {
                    return null;
                }
                integer = Integer.valueOf(userInput);
                intInput = false;
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }
        return integer;
    }

    /**
     *
     * @param message сообщение, которое будет передано пользователю
     * @return double
     */
    @Override
    public double getUserInputDouble(String message) {
        double integer = 0;
        boolean doubleInput = true;
        while (doubleInput) {
            try {
                System.out.print(message);
                integer = Double.valueOf(getUserInputCheckExit());
                doubleInput = false;
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }
        return integer;
    }

    /**
     *
     * @param message сообщение, которое будет передано пользователю
     * @return float
     */
    @Override
    public float getUserInputFloat(String message) {
        float integer = 0;
        boolean doubleInput = true;
        while (doubleInput) {
            try {
                System.out.print(message);
                integer = Float.valueOf(getUserInputCheckExit());
                doubleInput = false;
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }
        return integer;
    }

    /**
     * Проверяет сообщение на введенную команду 'exit'
     * @return
     */
    private String getUserInputCheckExit() {
        String input = scanner.nextLine().trim();
        if (input.equals("exit")) {
            throw new InterraptExitException("Выход из приложения");
        }
        return input;


    }
}

