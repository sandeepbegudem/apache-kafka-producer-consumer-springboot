package com.coding.with.sandeep.kafka.consumer.application.service;

import main.java.com.coding.with.sandeep.product.application.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(KafkaConsumerListener.class);
    @KafkaListener(topics = "product-notifications",
            groupId = "product_group_id")
    public void consumeTopic(Product product){
        LOGGER.info("consumed the event: [{}] the topic: product-notifications from kafka broker!\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\n",
                 product.toString());
    }
}
