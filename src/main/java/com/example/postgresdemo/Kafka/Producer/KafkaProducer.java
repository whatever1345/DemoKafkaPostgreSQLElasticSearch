package com.example.postgresdemo.Kafka.Producer;

import com.example.postgresdemo.Model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private KafkaTemplate<String, Message> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Message data){
        kafkaTemplate.send("demo", data);
        System.out.println("Data sent " + data.toString());
    }
}
