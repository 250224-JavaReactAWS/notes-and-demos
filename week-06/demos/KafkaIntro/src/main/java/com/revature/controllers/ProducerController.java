package com.revature.controllers;

import com.revature.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class ProducerController {

    // All this class will do is call the service to produce a message

    @Autowired
    private ProducerService producerService;

    @PostMapping("publish")
    public void publishEvent(@RequestParam("message") String message){
        // http://localhost:8080/kafka/publish?message=whatever
        producerService.sendEvent(message);
    }
}
