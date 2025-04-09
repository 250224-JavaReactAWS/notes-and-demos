package com.revature.services;

import com.revature.models.Item;
import com.revature.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FulfillmentService {

    private final Logger logger = LoggerFactory.getLogger(FulfillmentService.class);

    // This class will finally listen on the fulfillment topic
    @KafkaListener(topics = "fulfillment", groupId = "fulfillment-group")
    public void packageOrder(Order order){
        List<String> itemNames = new ArrayList<>();

        for (Item i: order.getCart()){
            itemNames.add(i.getName());
        }

        logger.info("Work order created! Packaging the following items: " + Arrays.toString(itemNames.toArray()));
    }
}
