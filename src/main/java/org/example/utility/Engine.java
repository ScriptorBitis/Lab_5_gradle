package org.example.utility;


import org.example.commands.*;
import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;
import org.example.models.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static org.example.managers.DumpManager.fillUpCollection;



public class Engine {
    private static boolean flag = true;
    private static Scanner consoleRead = new Scanner(System.in);

    public static void finishProgramm() {
        flag = false;
    }

    public static void runProgramm() {

        CollectionManager collectionManager=new CollectionManager(new HashMap<String,Ticket>());

        CommandManager.setUpCommand(new Help(collectionManager));
        CommandManager.setUpCommand(new Exit(collectionManager));
        CommandManager.setUpCommand(new Insert(2, collectionManager));
        CommandManager.setUpCommand(new Show(collectionManager));
        CommandManager.setUpCommand(new Clear(collectionManager));
        CommandManager.setUpCommand(new Info(collectionManager));
        CommandManager.setUpCommand(new RemoveKey(2, collectionManager));
        CommandManager.setUpCommand(new UpdateId(2, collectionManager));
        CommandManager.setUpCommand(new PrintAscending(collectionManager));
        CommandManager.setUpCommand(new MaxByCoordinates(collectionManager));
        CommandManager.setUpCommand(new ReplaceIfLowe(collectionManager));
        CommandManager.setUpCommand(new RemoveAnyByType(2, collectionManager));
        CommandManager.setUpCommand(new RemoveGreater(collectionManager));
        CommandManager.setUpCommand(new RemoveLower(collectionManager));
        CommandManager.setUpCommand(new Save(collectionManager));
        CommandManager.setUpCommand(new ExecuteScript(2,collectionManager));


        try {
            collectionManager.setCollection(fillUpCollection());

        } catch (IOException e) {
            System.out.println("Коллекцию считать не удалось!Файл поврежден или отсутствует!");
        }

        while (flag) {
            try {
                CommandManager.setUserRequest(consoleRead.nextLine().trim().split(" "));
            } catch (NoSuchElementException e) {
                System.out.println("Ярослав Вадимович, не надо никаких ctrl+d, пожалуйста\nЯ закрою прогу, ибо не надо всякую фигню забивать в консоль");
                return;
            }
        }
    }


}
