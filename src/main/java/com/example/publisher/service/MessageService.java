package com.example.publisher.service;

import com.example.publisher.dto.MessageDTO;
import com.example.publisher.helper.ActionType;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
public class MessageService {

    public MessageDTO generateRandomMessage() {
        MessageDTO message = new MessageDTO();
        Random random = new Random();
        String[] actionTypes = new String[]{
                ActionType.purchase,
                ActionType.subscription
        };

        message.setMsisdn(random.nextInt(Integer.MAX_VALUE));
        message.setAction(actionTypes[random.nextInt(actionTypes.length)]);
        message.setTimestamp(Instant.now().getEpochSecond());

        return message;
    }
}
