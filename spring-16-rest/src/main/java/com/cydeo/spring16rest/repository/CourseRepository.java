package com.cydeo.spring16rest.repository;

import com.cydeo.spring16rest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByCategory(String category);

}