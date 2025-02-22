package org.example;

import org.example.utility.Engine;
import org.example.exeptions.ЕmergencyЕxitException;

public class Main {
    public static void main(String[] args) {
        //TODO А теперь с переменной окружения довести до ума
        System.out.println(System.getenv());

        try {
            Engine.runProgramm();
        } catch (ЕmergencyЕxitException e) {
            System.out.println(e.getMessage());
        }

    }
}