package JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;

public class JSON_03 {
    public static void main (String[] args) {
        // Like this we will be able to read an already created .json file
        JsonObject jsonObject = null; // So we can use it inside and outside the try-catch block
        Gson gson = null;
        try {
            FileReader fileReader = new FileReader("fighterstest.json");

            gson = new GsonBuilder().setPrettyPrinting().create();
            // setPrettyPrinting modifies the JSON output so that is readable to humans
            // meaning that it will have spaces, blanks, line breaks and so on
            jsonObject = gson.fromJson(fileReader, JsonObject.class);

            System.out.println("Reading JSON...\n\n");
            System.out.println(gson.toJson(jsonObject));

            fileReader.close();
        } catch (IOException exception00) {
            exception00.printStackTrace();
        }

        // Like this we will be able to modify existen data in a .json file. Notice the index and String names
        // are really important
        System.out.println("\nWe modify Fighter 01 Vitality from 10 -> 15\n");

        JsonObject fighter01 = jsonObject.getAsJsonArray("Fighters").get(0).getAsJsonObject();
        fighter01.addProperty("Vitality", 15);
        System.out.println(gson.toJson(jsonObject));

        // Printing specific parts of the JSON Objects inside the Fighters Array
        String fighter01name = fighter01.get("Name").getAsString();
        System.out.println("Specific thing: " + fighter01name);

        System.out.println("-------------");

        for (String key : fighter01.keySet()) {
            System.out.println(key + ": " + fighter01.get(key));
        }

        // However we are not finished. We've only modified the data in jsonObject memory. The original file, outside
        // the project, has not yet been modified

    }
}
