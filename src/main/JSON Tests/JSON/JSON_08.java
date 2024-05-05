package JSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JSON_08 {
    public static void main(String[] args)  {
        JsonObject jsonObject = GSONCreator.loadFile(GSONCreator.filepathJSON2);
        JsonArray jsonArray = jsonObject.getAsJsonArray("UserInfo");

        for (int i = 0; i < jsonArray.size(); i ++) {
            JsonObject userObject = jsonArray.get(i).getAsJsonObject();
            if (userObject.get("UserName").getAsString().equals("UserTest2")) {
                jsonArray.remove(i);
                System.out.println("Your information has been successfully deleted from the Log DataBase");
                break;
            }
        }
        jsonObject.add("UserInfo",jsonArray);
        GSONCreator.saveFile(jsonObject, GSONCreator.filepathJSON2);
        GSONCreator.readFile(GSONCreator.filepathJSON2);



    }
}
