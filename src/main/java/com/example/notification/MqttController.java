package com.example.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
public class MqttController {
    @Autowired
    private MqttPublisher publisher;

    @GetMapping("/send")
    public String send(@RequestParam String msg) {
        publisher.sendMessage("payment.topic", msg);
        return "MQTT Sent: " + msg;
    }
}
