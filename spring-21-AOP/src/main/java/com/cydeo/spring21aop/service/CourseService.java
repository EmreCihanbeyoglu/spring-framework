package com.cydeo.spring21aop.service;


import com.cydeo.spring21aop.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);

    CourseDTO getCourseById(long courseId);

    List<CourseDTO> getCoursesByCategory(String category);

    List<CourseDTO> getCourses();

    void updateCourse(Long courseId, CourseDTO courseDTO);

    void deleteCourseById(Long courseId);

    void deleteCourses();

}