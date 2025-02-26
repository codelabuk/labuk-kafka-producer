package com.codelabuk.labuk_kafka_producer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "labuk-kafka-config")
public class LabukKafkaConfigProperties {
    private String topic;
}
