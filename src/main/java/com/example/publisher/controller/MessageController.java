package com.example.publisher.controller;

import com.example.publisher.dto.MessageDTO;
import com.example.publisher.service.MessageService;
import com.example.publisher.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    private MessageService messageService;
    private RestService restService;

    @Autowired
    public MessageController(MessageService messageService, RestService restService) {
        this.messageService = messageService;
        this.restService = restService;
    }

    @GetMapping("/sent")
    public ResponseEntity sentMessage() throws URISyntaxException {

        MessageDTO message = messageService.generateRandomMessage();

        ResponseEntity<String> result = restService.send(message, RestService.messagePath);

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
