package com.jason.producer;

import com.jason.modal.SmsMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgProducer {

    private final Logger log = LoggerFactory.getLogger(MsgProducer.class);

    @Autowired
    private KafkaTemplate<String, SmsMsg> template;

    // 从配置文件读取自定义属性
    @Value("${kafka.topic}")
    private String topic;

    @GetMapping("/msg/send")
    public String sendMsg(SmsMsg smsMsg) {
        ListenableFuture<SendResult<String, SmsMsg>> future = template.send(topic, smsMsg);
        future.addCallback(new ListenableFutureCallback<SendResult<String, SmsMsg>>() {
            @Override
            public void onSuccess(SendResult<String, SmsMsg> result) {
                log.info("===Producing message success");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("===Producing message failed");
            }

        });

        return  "send success";
    }
}
