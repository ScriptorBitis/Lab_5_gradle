package org.example.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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
import java.util.Map;

public class DumpManager {

    private static boolean wrongEnvironmentVariables = true;
    private static Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();

    static public Map<String, Ticket> fillUpCollection() throws NoSuchEnvironmentVariablesException, NotAFileException, InvalidArgumentsException {
        Type type = new TypeToken<HashMap<String, Ticket>>() {
        }.getType();
        checkEnvironmentVariable("lab_data");
        File file = new File(System.getenv("lab_data"));
        file.setReadable(true);
        HashMap<String, Ticket> tickets;
        try (FileReader fileReader = new FileReader(file)) {
            tickets = gson.fromJson(fileReader, type);
            System.out.println("Файл прочитан успешно!");
        } catch (Exception e) {
            wrongEnvironmentVariables = false;
            System.out.println("Коллекцию считать не удалось!Файл поврежден, отсутствует или пуст!");
            return new HashMap<>();
        }
        for (Validatable obj : tickets.values()) {
            if (obj.validate()==false) {
                System.out.println("Объекты записанной коллекции содержат неправильные значение.");
                return new HashMap<>();
            }
        }
        return tickets;
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
}
