package com.revature.services;

import com.revature.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private final Logger logger = LoggerFactory.getLogger(ShippingService.class);

    // This class with consume from the order topic and will produce to the fulfillment topic
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    // NOTE THE DIFFERENT GROUP ID SINCE THEY ARE DIFFERENT CONSUMER GROUPS
    @KafkaListener(topics = "orders", groupId = "shipping-group")
    public void createShippingLabel(Order order){
        logger.info("Creating shipping label for "+ order.getEmail());

        // Produce a message to the fulfillment topic which will be listened to by the fulfillment service
        logger.info("Sending the following items to the fulfillment topic" + order.getCart());
        this.kafkaTemplate.send("fulfillment", order);
    }
}
