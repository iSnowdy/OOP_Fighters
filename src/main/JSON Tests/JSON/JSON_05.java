package JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSON_05 {
    public static void main (String[] args) {
        String filePath = "fighterstest.json";
        Gson gson;
        JsonObject jsonObject;

        try {
            FileReader fileReader = new FileReader(filePath);

            gson = new GsonBuilder().setPrettyPrinting().create();
            // setPrettyPrinting modifies the JSON output so that is readable to humans
            // meaning that it will have spaces, blanks, line breaks and so on
            jsonObject = gson.fromJson(fileReader, JsonObject.class);
            fileReader.close();

            JsonObject newFighter = new JsonObject();
            newFighter.addProperty("Name", "Fighter7");
            newFighter.addProperty("Rank", "One");
            newFighter.addProperty("Type", "");
            newFighter.addProperty("Vitality", 1);
            newFighter.addProperty("Strength", 1);
            newFighter.addProperty("Dexterity", 1);

            JsonArray fighterArray = jsonObject.getAsJsonArray("Fighters");
            fighterArray.add(newFighter);

            FileWriter fileWriter = new FileWriter(filePath);
            gson.toJson(jsonObject, fileWriter);
            fileWriter.close();

            System.out.println("Reading JSON...\n\n");
            System.out.println(gson.toJson(jsonObject));

            fileReader.close();
        } catch (IOException exception00) {
            exception00.printStackTrace();
        }

    }
}
