package com.jason.serialization;

import com.jason.modal.SmsMsg;
import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class MsgSerializer implements Serializer<SmsMsg>{
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String topic, SmsMsg smsMsg) {
        return JSON.toJSONBytes(smsMsg);
    }

    @Override
    public void close() {

    }
}
