package com.cydeo.spring17restconsumingapi.controller;

import com.cydeo.spring17restconsumingapi.dto.DummyResponseWrapper;
import com.cydeo.spring17restconsumingapi.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    @Autowired
    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public ResponseEntity<User[]> getAllUsers() {
        return restTemplate.getForEntity(URI, User[].class);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URI + "/" + id, User.class);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserByIdWithEntity(@PathVariable("id") Long id) {
//        return restTemplate.getForEntity(URI + "/" + id, User.class);
//    }

    @GetMapping("/test")
    public ResponseEntity<DummyResponseWrapper> getUsersFromDummyAPI() {
        String dummyUrl = "https://dummyapi.io/data/v1/user?limit=5";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Content-Type", "application/json");
        headers.set("app-id", "6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(dummyUrl, HttpMethod.GET,  entity, DummyResponseWrapper.class);
    }

}
