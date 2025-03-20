package org.example.managers;

import org.example.commands.Executable;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для реализации шаблона "команда"
 * Хранение команд.
 */
public class CommandManager {
    private final Map<String, Executable> commandMap;

    public CommandManager(HashMap<String, Executable> ExecutableHashMap) {
        this.commandMap=ExecutableHashMap;
    }

    /**
     * Добавить команду в Map`у. Важно переопределить метод {@link Object#toString()},
     *чтобы корректно доставать команду
     * @param command
     */
    public void setUpCommand(Executable command) {
        commandMap.put(command.toString(), command);
    }

    /**
     * Получить Map`у команд
     * @return
     */
    public final Map<String, Executable> getCommands() {
        return commandMap;
    }

    /**
     * По полученному вводу достать соответствующую команду, реализующую интерфейс {@link Executable} и выполнить метод {@link Executable#execute(String[])}
     * @param splitedRequest - ввод с консоли
     */
    public void setUserRequest(String[] splitedRequest) {
        String request = splitedRequest[0];
        if (!this.getCommands().containsKey(request)) {
            System.out.println("Команда не распознана! Попробуйте ознакомиться с перечнем команд, введя 'help'.");
            return;
        }
        Executable command = this.getCommands().get(request);
        command.execute(splitedRequest);
    }
}
