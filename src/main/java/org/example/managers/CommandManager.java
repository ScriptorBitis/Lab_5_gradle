package org.example.managers;

import org.example.commands.*;


import java.util.HashMap;
import java.util.Map;


public class CommandManager {
    private final static Map<String, Executable> COMMAND_MAP = new HashMap<>();


    public static void setUpCommand(Executable command) {
        COMMAND_MAP.put(command.toString(), command);

    }

    public static final Map<String, Executable> getCommands() {
        return COMMAND_MAP;
    }

    public static void setUserRequest(String[] splitedRequest) {
        String request = splitedRequest[0];
        if (CommandManager.getCommands().containsKey(request)) {
            Executable command= CommandManager.getCommands().get(request);
            command.execute(splitedRequest);
        } else {
            System.out.println("Команда не распознана! Попробуйте ознакомиться с перечнем команд, введя 'help'.");
        }
    }


}
