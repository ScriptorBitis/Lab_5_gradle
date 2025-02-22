package org.example;

import org.example.utility.Engine;
import org.example.exeptions.ЕmergencyЕxitExeption;

public class Main {
    public static void main(String[] args) {
        //TODO А теперь с переменной окружения довести до ума
        System.out.println(System.getenv());

        try {
            Engine.runProgramm();
        } catch (ЕmergencyЕxitExeption e) {
            System.out.println(e.getMessage());
        }

    }
}