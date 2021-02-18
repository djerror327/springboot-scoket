package org.example;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController("/")
public class RestEX {
    Message message1=new Message();

    @PostMapping("/v1/save")
    public void persistData(@RequestBody String cpu){
//        if(!cpu.equals("{cpu:LoadPercentage}"))
        System.out.println(cpu);
    }

    @GetMapping("/v1/save")
    public String persistData(){
       return "{cpu:4}";
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message send(Message message) throws Exception {

        System.out.println(message.getFrom());
        System.out.println(message.getText());
//        message1.setFrom("dinusha");
//        message1.setText("hello world");
        System.out.println(message1.getFrom());
        return message1;
    }

    @PostMapping(value = "/m", consumes = "application/json", produces = "application/json")
    public void setMessage(@RequestBody Message message){
        System.out.println(message.getText());
        System.out.println(message.getFrom());
        message1.setFrom(message.getFrom());
        message1.setText(message.getText());
    }
}
