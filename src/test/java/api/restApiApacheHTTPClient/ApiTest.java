package api.restApiApacheHTTPClient;

//import cn.hutool.http.*;

import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.message.BasicHeader;
import org.testng.Assert;

import java.io.IOException;

public class ApiTest {
    public static void main(String[] args) throws IOException {

        HTTPClient httpclient = new HTTPClient();

        /*// Set up credentials
        BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope("httpbin.org", 80), // Replace with your target domain and port
                new UsernamePasswordCredentials("user", "passwd".toCharArray())
        );

        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build()) {

            HttpGet httpGet = new HttpGet(url);*/
        Header header = new BasicHeader("Authorization","Bearer some_token");
        String response = httpclient.getGetResponse("https://dog.ceo/api/breeds/image/random",header);

        System.out.println("response:" + response);
        Assert.assertTrue(response.contains("success"),"The response is not correct");
        System.out.println("This get api response is correct");

        String body = "{\n" +
                "  \"key\": \"value\"\n" +
                "}";

        String postResponse = httpclient.getPostResponse("https://httpbin.org/post",header,body);
        System.out.println("postResponse:" + postResponse);
        Assert.assertTrue(postResponse.contains("key"),"The response is not correct");
        System.out.println("This post api response is correct");


    }
}
