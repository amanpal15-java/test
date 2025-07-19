package com.example.test.config;

import com.example.test.constant.kafkaIpConstant;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

public final class KafkaProducerConfig {
    private KafkaProducerConfig() {}

    public static Properties getProducerProps() {
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaIpConstant.LOCAL_IP);
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        prop.setProperty(ProducerConfig.RETRIES_CONFIG, "3");
        prop.setProperty(ProducerConfig.LINGER_MS_CONFIG, "1");
        prop.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
        prop.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        prop.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        return prop;
    }
}

