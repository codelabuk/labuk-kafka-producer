package com.codelabuk.labuk_kafka_producer.controller;

import com.codelabuk.labuk_kafka_producer.service.LabukKafkaMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
@Slf4j
public class LabukKafkaController {

    @Autowired
    private LabukKafkaMessagePublisher labukKafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> eventPublish(@PathVariable String message) {
        try {
            labukKafkaMessagePublisher.sendMessage(message);
            return ResponseEntity.ok("message published to kafka topic");
        } catch (Exception ex) {
            log.error("Caught Exception for Kafka topic {}", message);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
