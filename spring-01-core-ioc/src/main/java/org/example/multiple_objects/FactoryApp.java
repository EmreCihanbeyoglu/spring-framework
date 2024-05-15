package org.example.multiple_objects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryApp {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class);
        Car carHonda = container.getBean("honda", Car.class);
        System.out.println(carHonda.getMake());

        Car carTesla = container.getBean("tesla", Car.class);
        System.out.println(carTesla.getMake());
    }



}
