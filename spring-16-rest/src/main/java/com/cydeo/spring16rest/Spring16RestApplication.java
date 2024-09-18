package com.cydeo.spring16rest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring16RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring16RestApplication.class, args);
    }


    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
