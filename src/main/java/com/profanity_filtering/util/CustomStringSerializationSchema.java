package com.profanity_filtering.util;

import org.apache.flink.streaming.connectors.kafka.KafkaSerializationSchema;
import org.apache.kafka.clients.producer.ProducerRecord;

import javax.annotation.Nullable;
import java.nio.charset.StandardCharsets;

/**
 * @Package com.retailersv1.CustomStringSerializationSchema
 * @Author jiahui
 * @Date 2025/5/2 09:00
 * @description: 1
 */
public class CustomStringSerializationSchema implements KafkaSerializationSchema<String> {
    private final String topic;

    public CustomStringSerializationSchema(String topic) {
        this.topic = topic;
    }
    @Override
    public ProducerRecord<byte[], byte[]> serialize(String s, @Nullable Long aLong) {
        return new ProducerRecord<>(topic, null, s.getBytes(StandardCharsets.UTF_8));
    }
}
