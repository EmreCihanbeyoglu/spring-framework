package org.example.injectionByField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaCourse {

    @Autowired
    OfficeHours officeHours;

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours: " + ( officeHours.getHours() + 150));
    }
}
