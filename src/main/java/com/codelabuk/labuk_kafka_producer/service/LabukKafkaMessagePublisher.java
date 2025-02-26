package com.codelabuk.labuk_kafka_producer.service;

import com.codelabuk.labuk_kafka_producer.config.LabukKafkaConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class LabukKafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private LabukKafkaConfigProperties kafkaConfigProperties;


    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, Object>> resultFromKafka =
                kafkaTemplate.send(kafkaConfigProperties.getTopic(), message);

        resultFromKafka.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("message {} sent with offset no = {}" ,  message , result.getRecordMetadata().offset());
            } else {
                log.error("Caught exception on kafka topic message sent", ex);
            }
        });
    }
}
