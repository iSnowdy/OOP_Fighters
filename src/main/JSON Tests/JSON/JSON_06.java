package JSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JSON_06 {
    public static void main(String[] args) {
        String filePath = "fighterstest.json";
        GSONCreator gsonCreator = new GSONCreator();
        JsonObject jsonObject = gsonCreator.loadFile(filePath);
        JsonObject newFighter = new JsonObject();
        newFighter.addProperty("Name", "Fighter7");
        newFighter.addProperty("Rank", "One");
        newFighter.addProperty("Type", "");
        newFighter.addProperty("Vitality", 1);
        newFighter.addProperty("Strength", 1);
        newFighter.addProperty("Dexterity", 1);

        JsonArray fighterArray = jsonObject.getAsJsonArray("Fighters");

        if (!gsonCreator.fighterEquals(newFighter, fighterArray)) {
            fighterArray.add(newFighter);
            System.out.println("Fighter added successfully!");
        } else {
            gsonCreator.removeFighter("Fighter7", jsonObject);
            System.out.println("Fighter removed successfully!");
        }

        gsonCreator.saveFile(jsonObject, filePath);
        gsonCreator.readFile(filePath);
    }


}
