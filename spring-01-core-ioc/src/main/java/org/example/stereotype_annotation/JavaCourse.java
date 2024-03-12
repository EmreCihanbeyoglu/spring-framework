package org.example.stereotype_annotation;

import org.springframework.stereotype.Component;

@Component
public class JavaCourse {
    public void getTeachingHours() {
        System.out.println("total teaching hours for Java: 25");
    }
}
