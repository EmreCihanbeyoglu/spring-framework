package com.cydeo.spring21aop.service.impl;

import com.cydeo.spring21aop.dto.CourseDTO;
import com.cydeo.spring21aop.entity.Course;
import com.cydeo.spring21aop.mapper.CourseMapper;
import com.cydeo.spring21aop.repository.CourseRepository;
import com.cydeo.spring21aop.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDTO createCourse(CourseDTO course) {
        courseRepository.save(courseMapper.convert(course, new Course()));
        return course;
    }

    @Override
    public CourseDTO getCourseById(long courseId) {
        Course course = courseRepository.findById(courseId).get();
        return courseMapper.convert(course, new CourseDTO());
    }

    @Override
    public List<CourseDTO> getCoursesByCategory(String category) {
        List<Course> list = courseRepository.findAllByCategory(category);
        return list.stream().map(obj -> courseMapper.convert(obj, new CourseDTO())).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourses() {
        List<Course> list = courseRepository.findAll();
        return list.stream().map(obj -> courseMapper.convert(obj, new CourseDTO())).collect(Collectors.toList());
    }

    @Override
    public void updateCourse(Long courseId, CourseDTO courseDTO) {

        Course course = courseMapper.convert(courseDTO, new Course());

        courseRepository.findById(courseId).ifPresent(dbCourse -> {

            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setDescription(course.getDescription());
            dbCourse.setRating(course.getRating());

            courseRepository.save(dbCourse);

        });

    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();
    }

    //@Loggable
    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

}