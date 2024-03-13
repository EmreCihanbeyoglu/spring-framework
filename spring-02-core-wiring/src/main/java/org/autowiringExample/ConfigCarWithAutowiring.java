package org.autowiringExample;

import org.springframework.context.annotation.Bean;
import org.wiringExample.Car;
import org.wiringExample.Person;

public class ConfigCarWithAutowiring {
    @Bean
    Car car() {
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }

    @Bean
    Person person(Car car) {
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car);
        return p;
    }
}
