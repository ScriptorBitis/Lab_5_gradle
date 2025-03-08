package org.example.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.Main;
import org.example.exeptions.InvalidArgumentsException;
import org.example.exeptions.NoSuchEnvironmentVariablesException;
import org.example.exeptions.NotAFileException;
import org.example.models.Ticket;
import org.example.utility.LocalDateTimeAdapter;
import org.example.utility.Validatable;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DumpManager {

    private static boolean wrongEnvironmentVariables = true;
    private static Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();

    static public Map<String, Ticket> fillUpCollection() throws NoSuchEnvironmentVariablesException, NotAFileException, InvalidArgumentsException {
        Type type = new TypeToken<Map<String, Ticket>>() {}.getType();
        checkEnvironmentVariable("lab_data");
        File file = new File(System.getenv("lab_data"));
        file.setReadable(true);
        try (FileReader fileReader = new FileReader(file)) {
            Map<String, Ticket> tickets = gson.fromJson(fileReader, type);
            System.out.println("Файл прочитан успешно!");
            validateCollection(tickets);
            return tickets;
        } catch (Exception e) {
            wrongEnvironmentVariables = false;
            System.out.println("Коллекцию считать не удалось!Файл поврежден, отсутствует или пуст!");
            return new HashMap<>();
        }
    }


    static public void writeCollection(CollectionManager collectionManager) throws IOException {
        String json = gson.toJson(collectionManager.getCollection());
        File file;
        if (wrongEnvironmentVariables) {
            checkEnvironmentVariable("lab_data");
            file = new File(System.getenv("lab_data"));
        } else {
            System.out.println("Коллекция будет записана в файл 'lab_data.json' без назначения переменной окружения");
            file = new File("lab_data.json");
        }
        file.setWritable(true);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(json);
        }
    }


    private static void checkEnvironmentVariable(String environmentVariable) throws NoSuchEnvironmentVariablesException, NotAFileException {
        if (System.getenv(environmentVariable) == null) {
            wrongEnvironmentVariables = false;
            throw new NoSuchEnvironmentVariablesException("Не найдена переменная окружения 'lab_data', ведущая к файлу!");
        }
        File file = new File(System.getenv(environmentVariable));
        if (!file.isFile() || !file.exists()) {
            wrongEnvironmentVariables = false;
            throw new NotAFileException("Файл не существует!");
        }
    }

    private static Map<String, Ticket> validateCollection(Map<String, Ticket> ticketMap) {
        Set<String> objToDelete = new HashSet();
        int cnt = 0;
        for (String key : ticketMap.keySet()) {
            if (ticketMap.get(key).validate() == false) {
                cnt++;
                objToDelete.add(key);
            }
        }
        for (String key : objToDelete) {
            ticketMap.remove(key);
        }
        if (cnt==0){
            return ticketMap;
        }
        System.out.println(cnt + " элемент(а) коллекции не прошел(ли) проверку при чтении файла.Они будут удалены.");
        return ticketMap;
    }
}
