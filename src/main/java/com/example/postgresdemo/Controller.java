package com.example.postgresdemo;

import com.example.postgresdemo.Kafka.Producer.KafkaProducer;
import com.example.postgresdemo.Model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class Controller {

    private KafkaProducer kafkaProducer;

    public Controller(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Message message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("MessageDocument sent to topic");
    }
}
