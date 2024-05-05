package JSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JSON_07 {
    public static void main(String[] args) {
        JsonObject jsonObject = GSONCreator.loadFile(GSONCreator.filepathJSON2);
        JsonObject newUserInfo = new JsonObject();
        JsonObject newOpponentInfo = new JsonObject();
        JsonArray opponentsArray = new JsonArray(); // Cuz Opponents is an Array

        newUserInfo.addProperty("UserName", "UserTest1");
        newUserInfo.addProperty("FighterName", "FighterTest2");
        newUserInfo.addProperty("Wins", 1); // Must change this later on to getWins from Fighter class
        newUserInfo.addProperty("Loses", 1); // Same change needed here
        // Consider also adding FighterRank to the UserInfo

        // How should we add this here hmm...
        newOpponentInfo.addProperty("Opponent Name", "");
        newOpponentInfo.addProperty("WinsVS", 2);
        newOpponentInfo.addProperty("LosesVS", 1);
        newOpponentInfo.addProperty("FighterRank", "Three");

        // Adding Opponent as an Array
        opponentsArray.add(newOpponentInfo);
        // Adding Opponent Array to newUserInfo as an Object
        newUserInfo.add("Opponents", opponentsArray);

        // Adding UserInfo (+ Opponent now) to the whole Array
        jsonObject.getAsJsonArray("UserInfo").add(newUserInfo);
        GSONCreator.saveFile(jsonObject, GSONCreator.filepathJSON2);

        GSONCreator.readFile(GSONCreator.filepathJSON2);

    }
}
