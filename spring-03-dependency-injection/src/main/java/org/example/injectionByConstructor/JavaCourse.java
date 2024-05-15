package org.example.injectionByConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaCourse {

    OfficeHours officeHours;

    @Autowired
    public JavaCourse(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours: " + ( officeHours.getHours() + 150));
    }
}
