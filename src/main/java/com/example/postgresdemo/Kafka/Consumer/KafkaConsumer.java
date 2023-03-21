package com.example.postgresdemo.Kafka.Consumer;

import com.example.postgresdemo.Model.MatchRecord;
import com.example.postgresdemo.Model.MatchRecordRepository;
import com.example.postgresdemo.Model.Message;
import com.example.postgresdemo.Model.MessageRepository;
import com.example.postgresdemo.Service.MessageDocumentService;
import com.example.postgresdemo.Service.MessageService;
import com.example.postgresdemo.elastic.Document.MessageDocument;
import com.example.postgresdemo.elastic.Document.MessageDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumer {


    private final MessageService messageService;
    private final MessageDocumentService messageDocumentService;

    public KafkaConsumer(MessageService messageService,
                         MessageDocumentService messageDocumentService){
        this.messageService = messageService;
        this.messageDocumentService = messageDocumentService;
    }

    @KafkaListener(topics = "demo", groupId = "myGroup")
    public void consume(Message message){
        System.out.println("Message received by consumer");
        messageService.saveMessage(message);
        messageService.saveRecord(message);
    }

    @KafkaListener(topics = "demo", groupId = "elasticGroup")
    public void consumeElastic(Message message){
        System.out.println("Message received by consumer of elastic search");
        messageDocumentService.createMessageIndex(message);
    }
}
