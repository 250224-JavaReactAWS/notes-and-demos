package com.revature.services;

import com.revature.models.Item;
import com.revature.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    /*
    This class is a pure consumer so all it does is consume messages from a given topic

    What is the groupId thing? The group id denotes the CONSUMER GROUP for the method
    A Consumer Group is a series of listeners (it can be multiple different listeners or the same listener
    repeated in multiple copies of the application) that work together to handle the events pushed to different
    topics/topic partitions.

    What is a topic partition? A topic partition splits up the event passed to a single topic in multiple logs
    that can be mapped to a specific consumer inside a consumer group

    Producer 1 -> Topic 1 (2 Partitions) -> Consumer Group 1 (Consumer 1 is linked to partition 1 and consumer 2 is
    linked to partition 2)
     */

    @KafkaListener(topics = "orders", groupId = "invoice-group")
    public void createInvoice(Order order){
        // Once an order is received we should calculate an invoice for the total amount and share it

        double finalPrice = 0;

        // Sum the prices of items time the quantity
        for (Item i: order.getCart()){
            finalPrice += i.getPrice() * i.getQuantity();
        }


        // Now that we have the subtotal we'll apply sales tax
        finalPrice *= 1.07;

        // Round the final price to 2 decimals
        finalPrice = Math.round(finalPrice * 100.0) / 100.0;

        // Finally, "Send" the invoice
        logger.info("Invoice created. Total price is $" + finalPrice);
    }
}
