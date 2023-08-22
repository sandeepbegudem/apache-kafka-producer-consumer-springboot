package com.coding.with.sandeep.kafka.producer.controller;

import com.coding.with.sandeep.kafka.producer.service.KafkaMessagePublisher;
import main.java.com.coding.with.sandeep.product.application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class ProducerController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @PostMapping("/post-messages")
    public void sendEvents(@RequestBody Product product){
        try{
            System.out.println("event has been posted successfully!...");
            publisher.sendMessageToTopic(product);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
