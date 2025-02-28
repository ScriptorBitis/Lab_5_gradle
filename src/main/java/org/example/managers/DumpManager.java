package org.example.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.exeptions.NoSuchEnvironmentVariablesException;
import org.example.exeptions.NotFileException;
import org.example.exeptions.WrongIdInputException;
import org.example.models.Ticket;
import org.example.utility.LocalDateTimeAdapter;

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

    static public Map<String, Ticket> fillUpCollection() throws NoSuchEnvironmentVariablesException, NotFileException {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        Type type = new TypeToken<HashMap<String, Ticket>>() {
        }.getType();


        checkEnvironmentVariable("lab_data");

        File file = new File(System.getenv("lab_data"));
        file.setReadable(true);

        try (FileReader fileReader = new FileReader(file)) {
            HashMap<String, Ticket> tickets = gson.fromJson(fileReader, type);
            System.out.println("Файл прочитан успешно!");
            return tickets;
        } catch (Exception e) {
            wrongEnvironmentVariables = false;
            System.out.println("Коллекцию считать не удалось!Файл поврежден или отсутствует!");
            return new HashMap<String, Ticket>();
        }

    }


    static public void writeCollection(CollectionManager collectionManager) throws IOException {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
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


    private static void checkEnvironmentVariable(String environmentVariable) throws NoSuchEnvironmentVariablesException,NotFileException {
        if (System.getenv(environmentVariable) == null) {
            wrongEnvironmentVariables = false;
            throw new NoSuchEnvironmentVariablesException("Не найдена переменная окружения 'lab_data', ведущая к файлу!");
        }
        File file = new File(System.getenv(environmentVariable));
        if (!file.isFile() || !file.exists()) {
            wrongEnvironmentVariables = false;
            throw new NotFileException("Файл не существует! Пасхалка ! Кулинич)");
        }
    }


}
