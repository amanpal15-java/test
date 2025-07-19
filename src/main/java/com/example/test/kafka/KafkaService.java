package com.example.test.kafka;

import com.example.test.constant.kafkaIpConstant;
import com.example.test.constant.kafkaTopicConstant;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.example.test.config.KafkaProducerConfig;
import com.example.test.config.KafkaConsumerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

public class KafkaService {


    private final KafkaProducer<String, String> producer;
    private final KafkaConsumer<String, String> consumer;

    public KafkaService() {
        Properties producerProps = KafkaProducerConfig.getProducerProps();
        producerProps.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaIpConstant.LOCAL_IP);
        producerProps.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProps.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        Properties consumerProps = KafkaConsumerConfig.getConsumerProps("my-group");
        consumerProps.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaIpConstant.DEV1_IP);
        consumerProps.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProps.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        this.producer = new KafkaProducer<>(producerProps);
        this.consumer = new KafkaConsumer<>(consumerProps);
        this.consumer.subscribe(Collections.singletonList(kafkaTopicConstant.FLINK_PENDING_DTO));
    }

    public void start() {
        // Start producer thread
        new Thread(this::produceMessages).start();
        // Start consumer thread
        new Thread(this::consumeMessages).start();
    }

    private void produceMessages() {
        int count = 0;
        try {
//            while (true) {
                int txn = 10;
                List<String> messages = new ArrayList<>();
                for(int i=0;i<txn;i += 1) {
                    String biz_id = "202310254793031219388039510" + i + "";
                    String esn = "310251" + i + "2973549863111";
                    ProducerRecord<String, String> record = new ProducerRecord<String, String>(kafkaTopicConstant.INIT_DTO, biz_id, "{\"routePayId\":\"" + biz_id + "\",\"tntInstId\":\"PAYTW3IN\",\"origRoutePayId\":\"749270131053428739\",\"externalEventCode\":\"PPBLC1IN01.pg.router.paytm.netbanking.payment.request@1.1.2\",\"externalSerialNo\":\"" + esn + "\",\"bizStatus\":\"S10\",\"externalAmount\":1234,\"externalCurrency\":\"INR\",\"referenceNo\":null,\"createdTime\":1656578520009,\"modifiedTime\":1656578520009,\"version\":1,\"debitorName\":null,\"debitorAccountNo\":null,\"creditorName\":null,\"creditorAccountNo\":null,\"alipayId\":null,\"merchantId\":\"123451338739\",\"instId\":\"UPIEW3IN\",\"instCode\":\"MASdTW7IN\",\"resultInfo\":{\"resultStatus\":\"S99\",\"resultCodeId\":\"AE11112060000000\",\"resultCode\":\"SUCCESS\",\"resultMsg\":\"\"},\"externalResultInfo\":{\"resultStatus\":\"S\",\"resultCodeId\":\"00000000\",\"resultCode\":\"SUCCESS\",\"resultMsg\":\"\"},\"extendInfo\":{\"externalResultInfo.resultCode\":\"SUCCESS\",\"externalResultInfo.resultCodeId\":\"00000000\",\"mbid\":\"9284537\",\"resultInfo.resultMsg\":\"\",\"cashierRequestId\":\"20160307152439035368067100b713d4914bf9a759d98ac65bbba7pgptheia86paytmlocal493301\",\"orderId\":\"2021080210110000010000PAYTW3IN168334920198571\",\"resultInfo.resultCodeId\":\"AE11112060000000\",\"payTime\":\"2022-06-30T14:12:00+05:30\",\"rrnCode\":\"121421142075\",\"fundDetailId\":\"2021080210110000010100PAYTW3IN168334942082813\",\"transId\":\"20210802111212800110168333727595184\",\"feeCurrency\":\"INR\",\"resultInfo.resultCode\":\"SUCCESS\",\"merchantName\":\"binu\",\"thirdResultInfo.resultCode\":\"SUCCESS\",\"externalResultInfo.resultMsg\":\"\",\"merchantId\":\"123451338739\",\"payMethod\":\"DEBIT_CARD\",\"externalResultInfo.resultStatus\":\"S\",\"idtBizOrderId\":\"20210802111212800110168333727595184\",\"createdTime\":\"2022-06-30T14:12:00+05:30\",\"virtualPaymentAddr\":\"9840159099@paytm\",\"serviceId\":\"PAYMENT\",\"merchantMcc\":\"90020\",\"alipayMerchantId\":\"216820000312259631902\",\"transBankDate\":\"20210802\",\"thirdResultInfo.resultCodeId\":\"0\",\"serviceInstId\":\"PPBEC1IN\",\"authCode\":\"121421142075\",\"ipRoleId\":\"216810000083612849337\",\"terminalType\":\"WEB\",\"instExchangeAbilityCode\":\"HDaVC1IN02.BANKCARD.PAYMENTQUERY\",\"instId\":\"UPIEW3IN\",\"feeAmount\":\"0\",\"resultInfo.resultStatus\":\"S07\",\"bizPatternId\":\"TPOP\",\"merchantTransId\":\"202108021610440093\",\"thirdResultInfo.resultMsg\":\"NA\",\"thirdResultInfo.resultStatus\":\"S01\"}}");
                    producer.send(record);
                    System.out.println("8001 dto : {}" + biz_id);
                    count++;
                }
                for(int i=0;i<txn;i += 2) {
                    String biz_id = "202310254793031219388039510" + i + "";
                    String esn = "310251" + i + "2973549863111";
                    ProducerRecord<String, String> record = new ProducerRecord<String, String>(kafkaTopicConstant.SUCCESS_DTO, biz_id, "{\"routePayId\":\"" + biz_id + "\",\"tntInstId\":\"PAYTW3IN\",\"origRoutePayId\":\"749270131053428739\",\"externalEventCode\":\"PPBLC1IN01.pg.router.paytm.netbanking.payment.request@1.1.2\",\"externalSerialNo\":\"" + esn + "\",\"bizStatus\":\"S10\",\"externalAmount\":1234,\"externalCurrency\":\"INR\",\"referenceNo\":null,\"createdTime\":1656578520009,\"modifiedTime\":1656578520009,\"version\":1,\"debitorName\":null,\"debitorAccountNo\":null,\"creditorName\":null,\"creditorAccountNo\":null,\"alipayId\":null,\"merchantId\":\"123451338739\",\"instId\":\"UPIEW3IN\",\"instCode\":\"MASdTW7IN\",\"resultInfo\":{\"resultStatus\":\"S99\",\"resultCodeId\":\"AE11112060000000\",\"resultCode\":\"SUCCESS\",\"resultMsg\":\"\"},\"externalResultInfo\":{\"resultStatus\":\"S\",\"resultCodeId\":\"00000000\",\"resultCode\":\"SUCCESS\",\"resultMsg\":\"\"},\"extendInfo\":{\"externalResultInfo.resultCode\":\"SUCCESS\",\"externalResultInfo.resultCodeId\":\"00000000\",\"mbid\":\"9284537\",\"resultInfo.resultMsg\":\"\",\"cashierRequestId\":\"20160307152439035368067100b713d4914bf9a759d98ac65bbba7pgptheia86paytmlocal493301\",\"orderId\":\"2021080210110000010000PAYTW3IN168334920198571\",\"resultInfo.resultCodeId\":\"AE11112060000000\",\"payTime\":\"2022-06-30T14:12:00+05:30\",\"rrnCode\":\"121421142075\",\"fundDetailId\":\"2021080210110000010100PAYTW3IN168334942082813\",\"transId\":\"20210802111212800110168333727595184\",\"feeCurrency\":\"INR\",\"resultInfo.resultCode\":\"SUCCESS\",\"merchantName\":\"binu\",\"thirdResultInfo.resultCode\":\"SUCCESS\",\"externalResultInfo.resultMsg\":\"\",\"merchantId\":\"123451338739\",\"payMethod\":\"DEBIT_CARD\",\"externalResultInfo.resultStatus\":\"S\",\"idtBizOrderId\":\"20210802111212800110168333727595184\",\"createdTime\":\"2022-06-30T14:12:00+05:30\",\"virtualPaymentAddr\":\"9840159099@paytm\",\"serviceId\":\"PAYMENT\",\"merchantMcc\":\"90020\",\"alipayMerchantId\":\"216820000312259631902\",\"transBankDate\":\"20210802\",\"thirdResultInfo.resultCodeId\":\"0\",\"serviceInstId\":\"PPBEC1IN\",\"authCode\":\"121421142075\",\"ipRoleId\":\"216810000083612849337\",\"terminalType\":\"WEB\",\"instExchangeAbilityCode\":\"HDaVC1IN02.BANKCARD.PAYMENTQUERY\",\"instId\":\"UPIEW3IN\",\"feeAmount\":\"0\",\"resultInfo.resultStatus\":\"S07\",\"bizPatternId\":\"TPOP\",\"merchantTransId\":\"202108021610440093\",\"thirdResultInfo.resultMsg\":\"NA\",\"thirdResultInfo.resultStatus\":\"S01\"}}");
                    producer.send(record);
                    System.out.println("8003 dto : {}" + biz_id);
                    count++;
                    int randomNumber = ThreadLocalRandom.current().nextInt(0, 10001); // 0 (inclusive) to 10001 (exclusive)
                    Thread.sleep(randomNumber);
                }

//            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            producer.close();
        }
    }

    private void consumeMessages() {
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Consumed: key=%s, value=%s, partition=%d, offset=%d%n",
                            record.key(), record.value(), record.partition(), record.offset());
                }
            }
        } finally {
            consumer.close();
        }
    }

    public static void main(String[] args) {
        KafkaService service = new KafkaService();
        service.start();
    }
}
