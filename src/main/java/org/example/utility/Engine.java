package org.example.utility;


import org.example.commands.*;
import org.example.exeptions.InterraptExitException;
import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;
import org.example.models.IdGenerator;
import org.example.models.Ticket;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.example.managers.DumpManager.fillUpCollection;

public class Engine {
    private boolean flag = true;
    private final Scanner consoleRead = new Scanner(System.in);
    private CollectionManager collectionManager;
    private CommandManager commandManager;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public void finishProgramm() {
        flag = false;
    }

    public void runProgramm() {

        this.collectionManager = new CollectionManager(new HashMap<>());
        this.commandManager = new CommandManager(new HashMap<>());

        commandManager.setUpCommand(new Help(1,this));
        commandManager.setUpCommand(new Exit(1, this));
        commandManager.setUpCommand(new Insert(2, this));
        commandManager.setUpCommand(new Show(1, this));
        commandManager.setUpCommand(new Clear(1, this));
        commandManager.setUpCommand(new Info(1, this));
        commandManager.setUpCommand(new RemoveKey(2, this));
        commandManager.setUpCommand(new UpdateId(2, this));
        commandManager.setUpCommand(new PrintAscending(1, this));
        commandManager.setUpCommand(new MaxByCoordinates(1, this));
        commandManager.setUpCommand(new ReplaceIfLowe(1, this));
        commandManager.setUpCommand(new RemoveAnyByType(2, this));
        commandManager.setUpCommand(new RemoveGreater(1, this));
        commandManager.setUpCommand(new RemoveLower(1, this));
        commandManager.setUpCommand(new Save(1, this));
        commandManager.setUpCommand(new ExecuteScript(2, this));

        try {
            Map<String, Ticket> tickets = fillUpCollection();
            collectionManager.setCollection(tickets);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        IdGenerator.restoreTicketIdCounter(this.collectionManager.getCollection());
        IdGenerator.restoreEventIdCounter(this.collectionManager.getCollection());

        while (flag) {
            try {
                commandManager.setUserRequest(consoleRead.nextLine().trim().split(" "));
            } catch (NoSuchElementException e) {
                System.out.println(ANSI_RED+"Ярослав Вадимович, не надо никаких ctrl+d, пожалуйста\nЯ закрою прогу, ибо не надо всякую фигню забивать в консоль"+ANSI_RESET);
                return;
            } catch (InterraptExitException e) {
                this.finishProgramm();
                System.out.println(ANSI_RED+e.getMessage()+ANSI_RESET);
            } catch (Exception e) {
                System.out.println(ANSI_RED+e+ANSI_RESET);
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
