package api.restAPIRestAssured;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class RestAssuredTest {

    public static void main(String[] args)
    {
        String url = "https://jsonplaceholder.typicode.com/posts";

        Map<String,String> headers = new HashMap<>();
        headers.put("Accept","appliation/json");

        Response response = RestAssuredUtil.sendGetRequest(url,headers,null);

        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";

        Response responsePost = RestAssuredUtil.sendPostRequest(url, headers, requestBody, null);

        System.out.println("Response Code for post: " + responsePost.getStatusCode());
        System.out.println("Response Body for post: " + responsePost.getBody().asString());
    }
}
