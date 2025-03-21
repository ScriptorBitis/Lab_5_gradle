package org.example;

import org.example.utility.Engine;

/**
 * Создается двигатель (ядро) и запускается программа
 * @author Alfarius
 * @see Engine
 */
public class Main {
    public static void main(String[] args) {
        //TODO переделать Exceptionы
        //TODO шизу убрать при чтении файла - ??? почитать доку либы
        Engine engine = new Engine();
        engine.runProgramm();
    }
}