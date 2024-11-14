package com.shop.kong.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Service
public class WebSocketService {

    @Value("${aruba.websocket.url}")
    private String websocketUrl;

    @Value("${aruba.websocket.key}")
    private String websocketKey;

    @Value("${aruba.websocket.username}")
    private String websocketUsername;

    @Value("${aruba.websocket.topic}")
    private String websocketTopic;

    private ArubaWebSocketClient webSocketClient;

    @PostConstruct
    public void connect() {
        try {
            URI uri = new URI(websocketUrl);
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", websocketKey);
            headers.put("UserName", websocketUsername);
            headers.put("Topic", websocketTopic);
            headers.put("sockopt", "[]");
            headers.put("sslopt", "{}");
            headers.put("fire_cont_frame", "False");
            headers.put("enable_multithread", "True");
            headers.put("skip_utf8_validation", "False");

            System.out.println("URI: " + uri);
            System.out.println("Headers: " + headers);

            webSocketClient = new ArubaWebSocketClient(uri, headers);
            webSocketClient.connect();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void disconnect() {
        if (webSocketClient != null && webSocketClient.isOpen()) {
            webSocketClient.close();
        }
    }
}
