package com.dinusha.soft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(App.class, args);


        for (; ; ) {
            Thread.sleep(1000);
            SocketTextHandler.webSocketSessionMap.forEach((key, val) -> {
                //check session close
                if (!val.isOpen()) {
                    try {
                        val.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("check socket is open.sending data to :" + val.getId());
                    try {
                        val.sendMessage(new TextMessage("{\"dinusha\":\"" + 23 + "\"}"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
