package org.example.utility;


import org.example.commands.*;
import org.example.exeptions.*;
import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;
import org.example.models.*;


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

        commandManager.setUpCommand(new Help(1,collectionManager,this));
        commandManager.setUpCommand(new Exit(1,collectionManager,this));
        commandManager.setUpCommand(new Insert(2, collectionManager));
        commandManager.setUpCommand(new Show(1,collectionManager));
        commandManager.setUpCommand(new Clear(1,collectionManager));
        commandManager.setUpCommand(new Info(1,collectionManager));
        commandManager.setUpCommand(new RemoveKey(2, collectionManager));
        commandManager.setUpCommand(new UpdateId(2, collectionManager));
        commandManager.setUpCommand(new PrintAscending(1,collectionManager));
        commandManager.setUpCommand(new MaxByCoordinates(1,collectionManager));
        commandManager.setUpCommand(new ReplaceIfLowe(1,collectionManager));
        commandManager.setUpCommand(new RemoveAnyByType(2, collectionManager));
        commandManager.setUpCommand(new RemoveGreater(1,collectionManager));
        commandManager.setUpCommand(new RemoveLower(1,collectionManager));
        commandManager.setUpCommand(new Save(1,collectionManager));
        commandManager.setUpCommand(new ExecuteScript(2, collectionManager,this));



        try {
            Map<String,Ticket> tickets =fillUpCollection();
            collectionManager.setCollection(tickets);

        } catch (NoSuchEnvironmentVariablesException e) {
            System.out.println(e.getMessage());

        }

        while (flag) {


            try {
                commandManager.setUserRequest(consoleRead.nextLine().trim().split(" "));
            } catch (NoSuchElementException e) {
                System.out.println("Ярослав Вадимович, не надо никаких ctrl+d, пожалуйста\nЯ закрою прогу, ибо не надо всякую фигню забивать в консоль");
                return;
            } catch (ЕmergencyЕxitException e) {
                finishProgramm();
                System.out.println(e.getMessage());
            }
            catch (Exception  e) {
                System.out.println(e);
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
