package com.example.kafkaclient.consumer.service;

import com.example.kafkaclient.model.Person;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "people", groupId = "group_id")
    public void consume(Person person) {
        logger.info(String.format("Consumed message -> %s %s %s", person.getId(), person.getName(), person.getSurname()));
    }

}
