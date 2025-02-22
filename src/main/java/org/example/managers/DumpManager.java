package org.example.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.models.Ticket;
import org.example.utility.LocalDateTimeAdapter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DumpManager {

    static public Map<String, Ticket> fillUpCollection()throws IOException{
        Gson gson=new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        Type type = new TypeToken<HashMap<String, Ticket>>() {}.getType();

        try (FileReader fileReader = new FileReader("Lab_data.json")) {
            HashMap<String, Ticket> tickets = gson.fromJson(fileReader, type);
            System.out.println("Файл прочитан успешно! Приятного изнасилования моей лабы =) ");
            return tickets;
        }
    }



    static public void writeCollection(CollectionManager collectionManager) throws IOException {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        String json = gson.toJson(collectionManager.getCollection());
        try (FileWriter fileWriter = new FileWriter("Lab_data.json")) {
            fileWriter.write(json);
        }
    }
}
