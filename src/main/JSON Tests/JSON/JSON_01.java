package JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JSON_01 {
    public static void main (String[] args) throws IOException {
        // throws Exception is saying that inputs/outputs of this class have a chane
        // of throwing that kind of Exception

        // JSON Writer
        ObjectMapper objectMapper = new ObjectMapper(); // ObjectMapper is in charge of writing JSON
        ObjectNode jsonNode = objectMapper.createObjectNode();
        // .put adds key:value pairs to the Object Node instance (JSON Object)
        jsonNode.put("name", "Abul Hasan");
        jsonNode.put("age", 23);
        jsonNode.put("city", "Lucknow");
        jsonNode.put("state", "Uttar Pradesh");
        jsonNode.put("country", "India");

        jsonNode.put("name", "Daniel Max");
        jsonNode.put("age", 26);
        jsonNode.put("city", "Babilonia");
        jsonNode.put("state", "Bangladesh");
        jsonNode.put("country", "Rusia");

        objectMapper.writeValue(new File("mydata.json"), jsonNode);
        // Exception?

        // JSON Reader
        // ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode1 = objectMapper.readTree(new File("mydata.json"));
        String name = jsonNode1.get("name").asText();
        int age = jsonNode1.get("age").asInt();
        String city = jsonNode1.get("city").asText();
        String state = jsonNode1.get("state").asText();
        String country = jsonNode1.get("country").asText();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Country: " + country);

        System.out.println("JSON File Created:" + jsonNode1);
    }
}
