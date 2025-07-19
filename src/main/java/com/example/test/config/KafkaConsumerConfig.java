package com.example.test.config;

import com.example.test.constant.kafkaIpConstant;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public final class KafkaConsumerConfig {
    private KafkaConsumerConfig() {}

    public static Properties getConsumerProps(String groupId) {
        Properties prop = new Properties();
        prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaIpConstant.LOCAL_IP);
        prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        prop.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        prop.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        prop.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        prop.setProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        prop.setProperty(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "10000");
        prop.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "500");
        return prop;
    }
}
