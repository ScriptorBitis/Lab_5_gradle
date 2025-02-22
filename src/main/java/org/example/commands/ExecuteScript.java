package org.example.commands;

import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ExecuteScript extends Command implements Executable {

    private HashSet<String> executedFiles= new HashSet<>();
    private boolean firstCommand;

    public ExecuteScript(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public ExecuteScript(int wordsCount) {
        super(wordsCount);
    }

    public ExecuteScript(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public ExecuteScript() {
    }


    @Override
    public void execute(String[] splitedConsoleRead) {
        File file = new File(splitedConsoleRead[1]);


        firstCommand=false;
        if (executedFiles.contains(splitedConsoleRead[1]) & !firstCommand) {
            System.out.println("Запущена защита от рекурскии : файл не должен вызывать сам себя");
            return;
        }
        executedFiles.add(splitedConsoleRead[1]);


        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] scriptLine = scanner.nextLine().trim().split(" ");
                System.out.println("\nВыполняется строка " + Arrays.toString(scriptLine));
                CommandManager.setUserRequest(scriptLine);
            }
        } catch (FileNotFoundException e) {
                reportMissingFile();
        }


        firstCommand=true;
        executedFiles.clear();
    }

    private void reportMissingFile() {
        System.out.println("Файл не найден, или название введено неверно. Попробуйте еще раз.");
    }

    @Override
    public void describe() {
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public String toString() {
        return "execute_script";
    }
}
