package com.example.postgresdemo.Service;

import com.example.postgresdemo.Model.Message;
import com.example.postgresdemo.elastic.Document.MessageDocument;
import com.example.postgresdemo.elastic.Document.MessageDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageDocumentService {
    MessageDocumentRepository messageDocumentRepository;

    public MessageDocumentService(MessageDocumentRepository messageDocumentRepository){
        this.messageDocumentRepository = messageDocumentRepository;
    }

    public void createMessageIndexBulk(final List<MessageDocument> products) {
        messageDocumentRepository.saveAll(products);
    }

    public void createMessageIndex(final Message message) {
        MessageDocument messageDocument = new MessageDocument();
        messageDocument.setId(message.getId());
        messageDocument.setBlueTeam(message.getBlueTeam());
        messageDocument.setRedTeam(message.getRedTeam());
        messageDocument.setResult(message.getResult());

        messageDocumentRepository.save(messageDocument);
    }
}
