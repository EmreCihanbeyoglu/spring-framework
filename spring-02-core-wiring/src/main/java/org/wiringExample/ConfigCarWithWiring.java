package org.wiringExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCarWithWiring {
    @Bean
    Car car() {
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }

    @Bean
    Person person() {
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car());
        return p;
    }

}
