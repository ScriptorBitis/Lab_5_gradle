package org.example.utility;


import org.example.commands.*;
import org.example.exeptions.NoKeyException;
import org.example.exeptions.NoSuchTypeException;
import org.example.exeptions.ScriptRecursionException;
import org.example.exeptions.WrongIdInputException;
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
    private boolean flag = true;
    private Scanner consoleRead = new Scanner(System.in);
    private CollectionManager collectionManager;
    private CommandManager commandManager;

    public void finishProgramm() {
        flag = false;
    }

    public void runProgramm() {

        this.collectionManager= new CollectionManager(new HashMap<String, Ticket>());
        this.commandManager=new CommandManager(new HashMap<String,Executable>());

        commandManager.setUpCommand(new Help(collectionManager));
        commandManager.setUpCommand(new Exit(1,collectionManager,this));
        commandManager.setUpCommand(new Insert(2, collectionManager));
        commandManager.setUpCommand(new Show(collectionManager));
        commandManager.setUpCommand(new Clear(collectionManager));
        commandManager.setUpCommand(new Info(collectionManager));
        commandManager.setUpCommand(new RemoveKey(2, collectionManager));
        commandManager.setUpCommand(new UpdateId(2, collectionManager));
        commandManager.setUpCommand(new PrintAscending(collectionManager));
        commandManager.setUpCommand(new MaxByCoordinates(collectionManager));
        commandManager.setUpCommand(new ReplaceIfLowe(collectionManager));
        commandManager.setUpCommand(new RemoveAnyByType(2, collectionManager));
        commandManager.setUpCommand(new RemoveGreater(collectionManager));
        commandManager.setUpCommand(new RemoveLower(collectionManager));
        commandManager.setUpCommand(new Save(collectionManager));
        commandManager.setUpCommand(new ExecuteScript(2, collectionManager,this));


        try {
            collectionManager.setCollection(fillUpCollection());

        } catch (IOException e) {
            System.out.println("Коллекцию считать не удалось!Файл поврежден или отсутствует!");
        }

        while (flag) {

            //TODO сократить catch
            try {
                commandManager.setUserRequest(consoleRead.nextLine().trim().split(" "));
            } catch (NoSuchElementException e) {
                System.out.println("Ярослав Вадимович, не надо никаких ctrl+d, пожалуйста\nЯ закрою прогу, ибо не надо всякую фигню забивать в консоль");
                return;
            } catch (ScriptRecursionException  e) {
                System.out.println(e.getMessage());
            } catch (WrongIdInputException e) {
                System.out.println(e.getMessage());
            } catch (NoKeyException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchTypeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}
