package com.revature.services;

import com.revature.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    /*
    This class will be a publisher/ producer class, its whole goal is to tell the world that an order
    has been placed and it doesn't do anything besides that
     */

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    // Add in the Kafka Template to send the information
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;


    public void sendOrder(Order order){
        // This method will send the order itself to the order topic
        logger.info("Sending a new order!");

//        this.kafkaTemplate.send("orders", order);
        // If we need to add in some more details for the message we can build it using the MessageBuilder api
        // like so
        Message<Order> message = MessageBuilder
                .withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, "orders")
                .build();

        this.kafkaTemplate.send(message);
    }
}
