package org.example.multiple_objects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ConfigApp {

    @Bean(name="honda")
    Car carHonda() {
        Car car = new Car();
        car.setMake("Honda");
        return car;
    }

    @Bean(name="tesla")
    Car carTesla() {
        Car car = new Car();
        car.setMake("Tesla");
        return car;
    }
}
