package com.cydeo.spring17restconsumingapi.controller;

import com.cydeo.spring17restconsumingapi.client.DummyUserClient;
import com.cydeo.spring17restconsumingapi.client.UserClient;
import com.cydeo.spring17restconsumingapi.dto.DummyUser;
import com.cydeo.spring17restconsumingapi.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Consume_FeignClient {


    private final UserClient userClient;
    private final DummyUserClient dummyUserClient;

    public Consume_FeignClient(UserClient userClient, DummyUserClient dummyUserClient) {
        this.userClient = userClient;
        this.dummyUserClient = dummyUserClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userClient.getAllUsers());
    }


    @GetMapping("/api/v1/dummyUsers")
    public ResponseEntity<List<DummyUser>> getAllDummyUsers() {
        return ResponseEntity.ok().body(dummyUserClient.getAllDummyUsers("6298ebfecd0551211fce37a6").getData());
    }


}
