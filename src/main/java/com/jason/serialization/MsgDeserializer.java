package com.jason.serialization;

import com.jason.modal.SmsMsg;
import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class MsgDeserializer implements Deserializer<SmsMsg>{
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public SmsMsg deserialize(String topic, byte[] bytes) {
        return JSON.parseObject(bytes, SmsMsg.class);
    }

    @Override
    public void close() {

    }
}
