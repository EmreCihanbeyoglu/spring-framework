package com.cydeo.spring16rest.controller;

import com.cydeo.spring16rest.dto.CourseDTO;
import com.cydeo.spring16rest.entity.Course;
import com.cydeo.spring16rest.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        List<CourseDTO> list = courseService.getCourses();
        return list;
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/category/{name}")
    public List<CourseDTO> getCoursesByCategory(@PathVariable("name") String category) {
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO courseDTO) {
        courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourseById(id);
    }

    @DeleteMapping
    public void deleteAllCourses() {
        courseService.deleteCourses();
    }

}
