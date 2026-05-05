package com.example.notification;

import org.apache.activemq.artemis.jms.client.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MqttPublisher {

    private final JmsTemplate jmsTemplate;

    public MqttPublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String topic, String message) {
        jmsTemplate.convertAndSend(new ActiveMQTopic(topic), message);
        System.out.println("Sent to topic: " + topic + " message: " + message);
    }
}
