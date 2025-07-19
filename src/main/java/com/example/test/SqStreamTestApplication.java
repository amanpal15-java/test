package com.example.test;

import com.example.test.config.KafkaConsumerConfig;
import com.example.test.config.KafkaProducerConfig;
import com.example.test.constant.Message;
import com.example.test.constant.kafkaTopicConstant;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@SpringBootApplication
public class SqStreamTestApplication {

	public static void main(String[] args) {

		SpringApplication.run(SqStreamTestApplication.class, args);

		Properties consumerProps = KafkaConsumerConfig.getConsumerProps("my-group");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps);
			// Subscribe to your topic
			consumer.subscribe(Collections.singletonList(kafkaTopicConstant.FLINK_PENDING_DTO));

			System.out.println("Waiting for messages...");
			while (true) {
				// Poll for new messages
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
				for (ConsumerRecord<String, String> record : records) {
					System.out.printf("Received message: key=%s, value=%s, partition=%d, offset=%d%n",
							record.key(), record.value(), record.partition(), record.offset());
				}
			}
		}

		KafkaProducer<String,String> producer = new KafkaProducer<String, String>(KafkaProducerConfig.getProducerProps());
		ProducerRecord<String, String> record1 = new ProducerRecord<String,String>(kafkaTopicConstant.INIT_DTO, "key1", Message.batch8001Working());

}


