package api.webSocketAPI;

import javax.websocket.*;

import java.net.URI;
import java.util.function.Consumer;

@ClientEndpoint
public class WebSocketClient {

    private Session session;
    //private String receivedMessage;
    private final Consumer<String> messageProcessor;
    //private String startMsg;

    public WebSocketClient(URI endpointURI, Consumer<String> messageProcessor) throws Exception {
        this.messageProcessor = messageProcessor;
        //this.startMsg = startMsg;
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(this, endpointURI);
    }

    @OnMessage
    public void onMessage (String message) {
        //this.receivedMessage = message;
        //System.out.println("Received: " + message);
        messageProcessor.accept(message);
    }

    public void sendMessage(String message) throws Exception {
        this.session.getBasicRemote().sendText(message);
    }

    //public String getReceivedMessage() {
    //    return receivedMessage;
    //}

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        //sendMessage(startMsg);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Connection closed: " + closeReason);
    }
}
