package org.example;

import org.example.utility.Engine;

/**
 * Создается двигатель ( ядро ) и запускается программа
 * @version 1.00
 * @author Alfarius
 */
public class Main {
    public static void main(String[] args) {
        //TODO переделать Exceptionы
        //TODO шизу убрать при чтении файла - ??? почитать доку либыы
        Engine engine = new Engine();
        engine.runProgramm();
    }
}