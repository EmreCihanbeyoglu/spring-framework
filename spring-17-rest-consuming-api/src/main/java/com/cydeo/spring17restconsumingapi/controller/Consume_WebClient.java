package com.cydeo.spring17restconsumingapi.controller;

import com.cydeo.spring17restconsumingapi.dto.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class Consume_WebClient {

    private final WebClient webClient = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();



    @GetMapping("/api/v3/users")
    public Flux<User> getUsers() {
        return webClient
                .get()
                .uri("/users")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(User.class);

    }

    @GetMapping("/api/v3/users/{id}")
    public Mono<User> getUser(@PathVariable("id") String id) {
        return webClient
                .get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }

}
