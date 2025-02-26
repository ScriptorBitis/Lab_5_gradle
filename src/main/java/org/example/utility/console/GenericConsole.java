package org.example.utility.console;

import java.util.Scanner;

public class GenericConsole<T> {
    private final Scanner scanner = new Scanner(System.in);
    private T obj;

    public GenericConsole(T obj) {
        this.obj = obj;
    }


    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void showType() {
        System.out.println("Тип объекта GenericConsole - " + obj.getClass().getName());
    }

    public T getUserInput(String message) {
        String input;
        T type = this.getObj();
        T userInput = null;


        boolean isRightInput = true;
        while (isRightInput) {
            try {
                System.out.println(message);
                input = scanner.nextLine().trim();
                if (type.getClass() == String.class) {
                    return (T) input;
                } else if (type.getClass() == Integer.class) {
                    return (T) Integer.valueOf(input);
                } else if (type.getClass() == Double.class) {
                    return (T) Double.valueOf(input);
                } else if (type.getClass() == Float.class) {
                    return (T) Float.valueOf(input);
                } else {
                    System.out.println("Введен неподдерживаемый тип!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
                isRightInput = true;
            }
        }
        return userInput;
    }
}
