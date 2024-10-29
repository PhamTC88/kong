package com.shop.kong.service;

import com.shop.kong.entity.Catalog;
import com.shop.kong.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("shop_topic_1", msg);
    }

    @KafkaListener(topics = "shop_topic_1", groupId = "kong")
    public void listen(String message) {
        System.out.println("Kafka - Received Message in group - kong: " + message);
    }

    @Override
    public List<Catalog> listCatalogs() {
        List<Catalog> listCatalogs = catalogRepository.findAll();
        sendMessage(listCatalogs.toString());
        return listCatalogs;
    }
}
