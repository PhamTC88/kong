package com.shop.kong.service;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class ArubaWebSocketClient extends WebSocketClient {

    private ScheduledExecutorService scheduler;

    public ArubaWebSocketClient(URI serverUri, Map<String, String> headers) {
        super(serverUri, headers);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to Aruba Streaming server");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
        // Handle the incoming message (e.g., parse and process location data)
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("WebSocket error: " + ex.getMessage());
    }
}
