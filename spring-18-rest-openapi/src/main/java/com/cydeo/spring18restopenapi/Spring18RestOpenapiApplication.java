package com.cydeo.spring18restopenapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring18RestOpenapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring18RestOpenapiApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("My new documentation title")
                        .version("v1")
                        .description("my new documentation description"));

    }
}
