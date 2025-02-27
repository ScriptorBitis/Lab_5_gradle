package org.example.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.exeptions.NoSuchEnvironmentVariablesException;
import org.example.exeptions.NotFileException;
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


    static public Map<String, Ticket> fillUpCollection() throws NoSuchEnvironmentVariablesException {
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
            System.out.println("Коллекцию считать не удалось!Файл поврежден или отсутствует!");
            return new HashMap<String,Ticket>();
        }

    }


    static public void writeCollection(CollectionManager collectionManager) throws IOException {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        String json = gson.toJson(collectionManager.getCollection());

            checkEnvironmentVariable("lab_data");
            File file = new File(System.getenv("lab_data"));
            file.setWritable(true);
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(json);

            }
        }


    private static void checkEnvironmentVariable(String environmentVariable) {
        if (System.getenv(environmentVariable) == null) {
            throw new NoSuchEnvironmentVariablesException("Не найдена переменная окружения 'lab_data', ведущая к файлу!");
        }
        File file = null;
        try {
            file = new File(System.getenv(environmentVariable));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (!file.isFile()) {
            throw new NotFileException("Переменная не ведет к файлу!");
        }
    }


}
