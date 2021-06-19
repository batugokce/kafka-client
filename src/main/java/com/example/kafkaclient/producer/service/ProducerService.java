package com.example.kafkaclient.producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private static final String TOPIC = "people";
    private static final String MESSAGE = "A new record has been created with this name, %s";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void createPerson(String name) {
        this.kafkaTemplate.send(TOPIC, String.format(MESSAGE, name));
    }
}
