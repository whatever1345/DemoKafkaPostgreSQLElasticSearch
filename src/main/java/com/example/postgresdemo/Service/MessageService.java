package com.example.postgresdemo.Service;

import com.example.postgresdemo.Model.MatchRecord;
import com.example.postgresdemo.Model.MatchRecordRepository;
import com.example.postgresdemo.Model.Message;
import com.example.postgresdemo.Model.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MatchRecordRepository matchRecordRepository;

    public MessageService(MessageRepository messageRepository, MatchRecordRepository matchRecordRepository){
        this.messageRepository = messageRepository;
        this.matchRecordRepository = matchRecordRepository;
    }

    public List<Message> getMessages(){
        return messageRepository.findAll();
    }

    public void saveMessage(Message message){
        Message processed = new Message(message.getBlueTeam(), message.getRedTeam(), message.getResult());
        this.messageRepository.save(processed);
    }

    public void saveRecord(Message message){
        MatchRecord matchRecordB;

        // Blue team record
        Optional<MatchRecord> matchRecordBlue = matchRecordRepository.findMatchRecordByTeam(message.getBlueTeam());
        if (matchRecordBlue.isPresent()){
            matchRecordB = matchRecordBlue.get();
            matchRecordB.setMatches(matchRecordB.getMatches() + 1);
            if (message.getResult() == 1)
                matchRecordB.setWins(matchRecordB.getWins() + 1);
        } else {
            int win = message.getResult() == 1 ? 1 : 0;
            matchRecordB = new MatchRecord(message.getBlueTeam(), win);
        }

        matchRecordRepository.save(matchRecordB);

        // Red team record
        MatchRecord matchRecordR;
        Optional<MatchRecord> matchRecordRed = matchRecordRepository.findMatchRecordByTeam(message.getRedTeam());
        if (matchRecordRed.isPresent()){
            matchRecordR = matchRecordRed.get();
            matchRecordR.setMatches(matchRecordR.getMatches() + 1);
            if (message.getResult() == 0)
                matchRecordR.setWins(matchRecordR.getWins() + 1);
        } else {
            int win = message.getResult() == 1 ? 0 : 1;
            matchRecordR = new MatchRecord(message.getRedTeam(), win);
        }

        matchRecordRepository.save(matchRecordR);
    }
}
