package api.webSocketAPI;

//import org.junit.jupiter.api.Test;
//import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.util.function.Consumer;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import com.neovisionaries.ws.client.*;

public class ClientTest {


    public static void main(String[] args) {


        /*當收到全推行情("messageType":1)，需發送 收到行情回覆 給後端*/
        // Don't forget to call disconnect() after use.
        // websocket.disconnect();
        try {
            /*WebSocket websocket = new WebSocketFactory()
                    .createSocket("ws://localhost:8765")
                    .addListener(new WebSocketAdapter() {
                        @Override
                        public void onTextMessage(WebSocket ws, String message) {
                            System.out.println("Received msg: " + message);
                        }
                    })
                    .connect();
            websocket.sendText("hello server");
            Thread.sleep(1000); // Wait for response
            websocket.disconnect();*/
            //*
            URI endpointURI = new URI("wss://vjp.app-alpha.com:18008/websocket");
            String startMsg = "{\n" +
                    "    \"messageType\": \"1\",\n" +
                    "    \"mobileType\": \"iPhone 13\",\n" +
                    "    \"mt4account\": \"\",\n" +
                    "    \"serverId\": \"\",\n" +
                    "    \"sign\": \"99E1556E8BD0032C63E9DBB2C643E77A\",\n" +
                    "    \"timeZone\": \"9\",\n" +
                    "    \"ts\": \"1717116488871\",\n" +
                    "    \"version\": \"3.47.6\",\n" +
                    "    \"compreType\": 1\n" +
                    "}\n";

            Consumer<String> processor = message -> {
                //System.out.println("Custom processing of message: " + message);
                JsonObject obj = JsonParser.parseString(message).getAsJsonObject();
               // JSONObject obj = new JSONObject(message);
                if (obj.has("data") && obj.has("messageType")) {
                    JsonObject data = obj.getAsJsonObject("data");
                    if (data.has("market")) {
                        System.out.println("market data len: " + data.get("market").getAsString().length());
                        System.out.println("messageType: " + obj.get("messageType"));
                    }
                }
            };
            WebSocketClient client = new WebSocketClient(endpointURI, processor);
            System.out.println("start");
            client.sendMessage(startMsg);

            System.out.println("Press Ctrl+C to exit");
            Thread.currentThread().join();

            //Thread.sleep(1000); // Wait for response
        } catch (Exception e) {
            System.out.println("exception: " + e);
        }
        //assertEquals("ExpectedResponse", client.getReceivedMessage());
        System.out.println("done");
    }
}
