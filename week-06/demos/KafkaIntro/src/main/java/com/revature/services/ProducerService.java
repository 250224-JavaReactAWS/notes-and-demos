package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {


    /*
    This class is our ProducerService and its whole goal is to push or publish an event to our Kafka Event Manager
    The event will the be consumed by any listening or consuming groups and from there actions will take place
     */

    // Let's add in a logger for our application
    public static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    // The next thing we need to get started is a KafkaTemplate
    // This define the key-value pair that represents an event.
    // The key decides where the event is going the value is the value of the event (string, object, etc)

    @Autowired // Field Injection (not recommended but useful for only one dependency)
    private KafkaTemplate<String, String> kafkaTemplate;

    // Method to send an event
    public void sendEvent(String message){
        // Log the message sent
        logger.info("Message sent -> " + message);

        // Publish the event to the Kafka Event manager
        this.kafkaTemplate.send("test", message);
    }

    /*
    This is sending a event to the "Test" topic, think of a topic like a youtube channel that contains several
    videos and more can be published at any time. Any consumer that is subscribed to that topic is then notified and
    receives the event
     */
}
