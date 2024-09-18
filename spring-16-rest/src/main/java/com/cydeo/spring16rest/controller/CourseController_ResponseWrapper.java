package com.cydeo.spring16rest.controller;

import com.cydeo.spring16rest.entity.ResponseWrapper;
import com.cydeo.spring16rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/v3")
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    @Autowired
    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("version", "cydeov3")
                .body(new ResponseWrapper("successfully retrieved all courses", courseService.getCourses()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("version", "cydeov3")
                .body(new ResponseWrapper("successfully retrieved course by id", courseService.getCourseById(id)));
    }

}
