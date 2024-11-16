package api.restAPIRestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestAssuredUtil {

    public static Response sendGetRequest(String url,Map<String, String> headers, Map<String, String> cookies)
    {
        RequestSpecification request = RestAssured.given();
        if (headers != null) {
            request.headers(headers);
        }

        if (cookies != null) {
            request.cookies(cookies);
        }

        return request.get(url);
    }

    public static Response sendPostRequest(String url, Map<String, String> headers, Object body, Map<String, String> cookies)
    {
        RequestSpecification request = RestAssured.given();

        if (headers != null) {
            request.headers(headers);
        }

        if (cookies != null) {
            request.cookies(cookies);
        }

        if (body != null) {
            request.body(body);
        }

        // Send the POST request and return the response
        return request.post(url);
    }
}
