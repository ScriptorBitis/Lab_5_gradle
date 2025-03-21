package org.example.commands;

import org.example.exeptions.InvalidArgumentsException;
import org.example.exeptions.NoSuchEnvironmentVariablesException;
import org.example.exeptions.ScriptRecursionException;
import org.example.utility.Engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Класс - команда для выполнения скрипта
 */
public class ExecuteScript extends Command implements Executable {
    /**
     * Доступ к двигателю, к которому привязана команда ( доступ к {@link org.example.managers.CollectionManager} и {@link org.example.managers.CommandManager}
     */
    private Engine engine;
    /**
     * Set для хранения файлов, которые выполнялись
     */
    private final Set<String> executedFiles = new HashSet<>();
    /**
     * Дурацкий флаг для контроля рекурсии
     */
    private boolean firstCommand;

    /**
     * Стандартный конструктор
     * @param wordsCount количество слов
     * @param engine ссылка на {@link Engine}
     */
    public ExecuteScript(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine = engine;
    }

    /**
     *  Выполнить скрип
     * @param splitedConsoleRead ввод необходимых аргументов с консоли. Среди которых переменная окружения
     */
    @Override
    public void execute(String[] splitedConsoleRead) {
        validateCommand(splitedConsoleRead);
        File file = new File(System.getenv(splitedConsoleRead[1]));
        file.setReadable(true);
        firstCommand = false;
        if (executedFiles.contains(splitedConsoleRead[1]) & !firstCommand) {
            throw new ScriptRecursionException("Запущена защита от рекурскии : файл не должен вызывать сам себя");
        }
        executedFiles.add(splitedConsoleRead[1]);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] scriptLine = scanner.nextLine().trim().split(" ");
                System.out.println("\nВыполняется строка " + Arrays.toString(scriptLine));
                this.engine.getCommandManager().setUserRequest(scriptLine);
            }
        } catch (FileNotFoundException e) {
            reportMissingFile();
        }
        firstCommand = true;
        executedFiles.clear();
    }

    /**
     * @param splitedConsoleRead -ввод с консоли
     * @throws InvalidArgumentsException
     * @throws NoSuchEnvironmentVariablesException
     * @throws IllegalArgumentException
     */
    @Override
    public void validateCommand(String[] splitedConsoleRead) throws InvalidArgumentsException, NoSuchEnvironmentVariablesException, IllegalArgumentException {
        if (splitedConsoleRead.length != this.wordsCount) {
            throw new IllegalArgumentException("У команды execute_script file_name 2 аргумента.");
        }
        if (System.getenv(splitedConsoleRead[1]) == null) {
            throw new NoSuchEnvironmentVariablesException("Введена неправильная переменная окружения!");
        }
        File file = new File(splitedConsoleRead[1]);
        if (!file.exists()) {
            throw new IllegalArgumentException("Файла не существует!");
        }
    }

    /**
     * Просто сообщения о несуществующем файле
     */
    private void reportMissingFile() {
        System.out.println("Файл не найден, или название переменной введено неверно. Попробуйте еще раз.");
    }

    /**
     * Описать, что делает команда
     */
    @Override
    public void describe() {
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    /**
     * Переопределенный метод для работы {@link org.example.managers.CommandManager#setUpCommand(Executable)}
     * @return имя команды, которое надо ввести с консоли
     */
    @Override
    public String toString() {
        return "execute_script";
    }
}
