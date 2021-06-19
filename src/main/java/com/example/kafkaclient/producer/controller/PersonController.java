package com.example.kafkaclient.producer.controller;

import com.example.kafkaclient.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final ProducerService producerService;

    @GetMapping("/create")
    public void createPerson(@RequestParam String name) {
        producerService.createPerson(name);
    }
}
