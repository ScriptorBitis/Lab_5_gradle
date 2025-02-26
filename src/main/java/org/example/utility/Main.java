package org.example.utility;

import org.example.exeptions.ЕmergencyЕxitException;
import org.example.managers.DumpManager;



public class Main {
    public static void main(String[] args) {
        //TODO А теперь с переменной окружения довести до ума
        //TODO ID+ валидация команд
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(System.getenv().containsKey("lab_data"));
//        System.out.println(System.getenv().values());
//        System.out.println(System.getenv("lab_data"));

//        GenericConsole<Integer> iob=new GenericConsole<>(124124);
//        iob.showType();
//        System.out.println(iob.getUserInput("Введите число"));

        try {
            Engine engine=new Engine();
            engine.runProgramm();
        } catch (ЕmergencyЕxitException e) {
            System.out.println(e.getMessage());
        }

    }
}