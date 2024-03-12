package org.example.stereotype_annotation;

import org.springframework.stereotype.Component;

@Component
public class AgileCourse {
    public void getTeachingHours() {
        System.out.println("total teaching hours for Agile: 15");
    }
}
