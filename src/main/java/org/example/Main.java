package org.example;

import org.example.utility.Engine;
import org.example.exeptions.ЕmergencyЕxitException;

public class Main {
    public static void main(String[] args) {
        //TODO А теперь с переменной окружения довести до ума
        //TODO ID+ валидация команд
        System.out.println(System.getenv());

        try {
            Engine engine=new Engine();
            engine.runProgramm();
        } catch (ЕmergencyЕxitException e) {
            System.out.println(e.getMessage());
        }

    }
}