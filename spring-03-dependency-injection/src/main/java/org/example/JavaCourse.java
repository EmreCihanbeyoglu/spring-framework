package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaCourse {

    // injection by field
//    @Autowired
//    OfficeHours officeHours;

    // injection by constructor
    /***
     * this way is the suggested way to make injection with stereotype.
     * Additionally from Spring 4.3 even you don't need to put @AutoWired annotation if there is only one constructor
     * since Spring will handle it automatically. So it is safe to use lombok allArgconstrucotr to inject the object into class
     */
    OfficeHours officeHours;
    @Autowired
    public JavaCourse(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours: " + ( officeHours.getHours() + 150));
    }
}
