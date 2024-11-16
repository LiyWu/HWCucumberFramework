package interviewPrepare;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonHandle {

    public static void main(String[] args) {
        String message = "{\n" +
                "  \"id\": 101,\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"email\": \"johndoe@example.com\",\n" +
                "  \"age\": 30,\n" +
                "  \"isEmployee\": true,\n" +
                "  \"skills\": [\"JavaScript\", \"Python\", \"Java\"],\n" +
                "  \"address\": {\n" +
                "    \"street\": \"123 Main St\",\n" +
                "    \"city\": \"Springfield\",\n" +
                "    \"state\": \"IL\",\n" +
                "    \"postalCode\": \"62704\"\n" +
                "  },\n" +
                "  \"projects\": [\n" +
                "    {\n" +
                "      \"projectId\": 1,\n" +
                "      \"projectName\": \"Website Redesign\",\n" +
                "      \"status\": \"Completed\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"projectId\": 2,\n" +
                "      \"projectName\": \"API Development\",\n" +
                "      \"status\": \"In Progress\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";


        JsonObject object = JsonParser.parseString(message).getAsJsonObject();

        String id = object.get("id").getAsString();
        System.out.println("id:" + id);

        JsonObject address = object.getAsJsonObject("address");
        String city = address.get("city").getAsString();
        System.out.println("city:" + city);

        JsonArray project = object.getAsJsonArray("projects");
        JsonObject firstF = project.get(1).getAsJsonObject();
        String projectID = firstF.get("projectId").getAsString();
        System.out.println("projectID:" + projectID);


    }
}
