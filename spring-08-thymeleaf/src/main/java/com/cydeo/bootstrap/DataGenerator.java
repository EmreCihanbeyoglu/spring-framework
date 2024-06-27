package com.cydeo.bootstrap;

import com.cydeo.model.Student;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    public static List<Student> createStudents() {
        Faker faker = new Faker();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add((
                    new Student(faker.name().firstName(),
                            faker.name().lastName(),
                            faker.number().numberBetween(20, 50),
                            faker.address().state()
                    )));
        }

        return students;
    }

}
