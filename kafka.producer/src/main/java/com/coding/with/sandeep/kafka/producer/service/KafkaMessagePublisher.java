package com.coding.with.sandeep.kafka.producer.service;

import main.java.com.coding.with.sandeep.product.application.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessagePublisher.class);

    public void sendMessageToTopic(Product product){
        try {


            CompletableFuture<SendResult<String, Object>> future =
                    kafkaTemplate.send("product-notifications", product);

            future.whenComplete((result, exception) ->
            {
                if (exception == null) {
                    LOGGER.info("events [{}] for topic: product-notifications was sent to kafka broker!\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\n",
                             product.toString());

                    System.out.println("events as been sent to the topic: product-notifications" + result.getRecordMetadata().offset());
                } else {
                    System.out.println("events was not sent to the topic: product-notifications" + exception.getMessage());
                }
            });
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
