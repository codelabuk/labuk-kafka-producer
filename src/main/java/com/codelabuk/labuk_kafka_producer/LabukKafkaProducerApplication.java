package com.codelabuk.labuk_kafka_producer;

import com.codelabuk.labuk_kafka_producer.config.LabukKafkaConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(LabukKafkaConfigProperties.class)
public class LabukKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabukKafkaProducerApplication.class, args);
	}

}
