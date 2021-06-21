package com.example.kafkaclient.producer.service;

import com.example.kafkaclient.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private static final String TOPIC = "people";
    private static final String MESSAGE = "A new record has been created with this name, %s";
    private final KafkaTemplate<String, Person> kafkaTemplate;

    public void createPerson(String name) {
        Person person = Person.newBuilder()
                .setId(1L)
                .setName(name)
                .setSurname("Surname")
                .build();
        this.kafkaTemplate.send(TOPIC, name, person);
    }
}
