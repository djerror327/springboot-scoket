package com.dinusha.soft;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.standard.StandardWebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

    public static Map<String, WebSocketSession> webSocketSessionMap = new HashMap<>();
//    int a=0;

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // The WebSocket has been closed
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // The WebSocket has been opened
        // I might save this session object so that I can send messages to it outside of this method

        // Let's send the first message
        session.sendMessage(new TextMessage("You are now connected to the server. This is the first message."));
//        webSocketSessionMap.put(session.getId(), session);
//        int a = 0;
        for (; ; ) {
            Thread.sleep(800);
//            a += 1;
            session.sendMessage(new TextMessage("{\"cpu\":\"" + App.a + "\"}"));
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        // A message has been received
        System.out.println("Message received: " + textMessage.getPayload());
    }
}
