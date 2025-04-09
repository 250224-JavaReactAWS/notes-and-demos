package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    /*
    This class is our ConsumerService which will consume messages on the "test" topic.

    NOTE THERE IS NO DIRECT RELATIONSHIP BETWEEN THE PRODUCERSERVICE AND CONSUMERSERVICE
    This means that they are very loosely coupled

    Whenever an event on the test topic comes in we will handle it in this class
     */

    // Let's add in a logger
    public static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);


    // Let's create a method to consume the event
    @KafkaListener(topics = "test", groupId = "test-group")
    // This annotation makes it so this method gets called under specific parameters
    public void consume(String message){
        logger.info("Message received -> " + message);
    }
}
