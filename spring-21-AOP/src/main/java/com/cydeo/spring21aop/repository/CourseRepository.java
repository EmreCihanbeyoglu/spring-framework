package com.cydeo.spring21aop.repository;


import com.cydeo.spring21aop.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByCategory(String category);

}
