package api.restApiApacheHTTPClient;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class HTTPClient {
    CloseableHttpClient httpClient;
    /*public HTTPClient()
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
    }*/
    public String getGetResponse(String url, Header header) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader(header);

            try(CloseableHttpResponse response = httpClient.execute(httpGet)){

                return EntityUtils.toString(response.getEntity());

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

    }

    public String getPostResponse(String url,Header header,String body) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(body, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);

            try(CloseableHttpResponse response = httpClient.execute(httpPost)){
                String responseBody = EntityUtils.toString(response.getEntity());
                return responseBody;

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
    }

    /*public void setCookie(Cookie cookie) {
        this.httpCookieStore.addCookie(cookie);
        this.httpClient = getClient();
    }*/

}
