package JSON;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSetMetaData;
import java.sql.*;

public class JSON_02 {
    public static void main (String[] args) throws IOException {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        jsonObject.put("Name", "Fighter6");
        jsonObject.put("Rank", "One");
        jsonObject.put("Type", "Vitality");
        jsonObject.put("Vitality", 15);
        jsonObject.put("Strength", 5);
        jsonObject.put("Dexterity", 2);
        jsonArray.put(jsonObject);

        System.out.println("---");
        // System.out.println(jsonObject);

        jsonObject.put("Fighters", jsonArray);

        System.out.println(jsonObject.toString());





        try {
            FileReader fileReader = new FileReader("fighterstest.json");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int lineNumber = 0;
            int endLine = 500;

            while ((line = bufferedReader.readLine()) != null && lineNumber < endLine) {
                System.out.println(line);
                lineNumber ++;
            }
            bufferedReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }



    }
}
