package com.example.publisher.service;

import com.example.publisher.dto.MessageDTO;
import com.example.publisher.helper.ActionType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@PropertySource("classpath:application.properties")
public class RestService {

    public static final String messagePath = "/api/message";

    @Value("${rest.host}")
    private String baseHost;

    public ResponseEntity<String> send(Object payload, String path) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = this.baseHost + path;
        URI uri = new URI(baseUrl);

        return restTemplate.postForEntity(uri, payload, String.class);
    }
}
