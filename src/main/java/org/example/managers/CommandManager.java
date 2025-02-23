package org.example.managers;

import org.example.commands.*;
import java.util.HashMap;
import java.util.Map;


public class CommandManager {
    private final  Map<String, Executable> COMMAND_MAP = new HashMap<>();

    public CommandManager(HashMap<String, Executable> stringExecutableHashMap) {
    }

    public void setUpCommand(Executable command) {
        COMMAND_MAP.put(command.toString(), command);

    }

    public final Map<String, Executable> getCommands() {
        return COMMAND_MAP;
    }

    public void setUserRequest(String[] splitedRequest) {
        String request = splitedRequest[0];
        if (this.getCommands().containsKey(request)) {
            Executable command= this.getCommands().get(request);
            command.execute(splitedRequest);
        } else {
            System.out.println("Команда не распознана! Попробуйте ознакомиться с перечнем команд, введя 'help'.");
        }
    }


}
