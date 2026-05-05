package com.example.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    private static final Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);
    @JmsListener(
            destination = "payment.topic",
            containerFactory = "jmsListenerContainerFactory",
            subscription = "notification-subscription"
    )
    public void process(String msg) {
        logger.info("Notification received message: {}", msg);
    }
}

