package org.example.utility;

import org.example.exeptions.ЕmergencyЕxitException;




public class Main {
    public static void main(String[] args) {
        try {
            Engine engine=new Engine();
            engine.runProgramm();
        } catch (ЕmergencyЕxitException e) {
            System.out.println(e.getMessage());
        }

    }
}