package org.example.injectionByConstructor;

import org.springframework.stereotype.Component;

@Component
public class SeleniumCourse {
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours: 15");
    }
}
