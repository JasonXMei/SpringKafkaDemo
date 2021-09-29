package com.jason.consumer;

import com.jason.modal.SmsMsg;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MsgConsumer {

    private final Logger log = LoggerFactory.getLogger(MsgConsumer.class);

    @KafkaListener(topics = "${kafka.topic}")
    public void onMsg(ConsumerRecord<String, SmsMsg> consumerRecord, Acknowledgment acknowledgment) {
        log.info("===Consumer message: {}", consumerRecord.value());
        acknowledgment.acknowledge();
    }

}
