package org.example.utility.console;

import java.util.Scanner;
import org.example.exeptions.ЕmergencyЕxitExeption;

public class StandartConsole implements Console {
    private Scanner scanner = new Scanner(System.in);

    public StandartConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getUserInputString() {
        String userInput = scanner.nextLine().trim();
        if (userInput.equals("exit")) {
            throw new ЕmergencyЕxitExeption("Выход из консоли");
        }
        return userInput;
    }
}

