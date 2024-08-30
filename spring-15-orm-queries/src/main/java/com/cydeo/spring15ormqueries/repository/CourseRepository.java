package com.cydeo.spring15ormqueries.repository;

import com.cydeo.spring15ormqueries.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // find all courses by category
    List<Course> findByCategory(String category);

    // find all courses by category and order the entites by name
    List<Course> findByCategoryOrderByName(String category);


    // checks if a course wih provided name exists, return true if course exists, false otherwise
    Boolean existsByName(String name);


    //return the count of courses for the provided category
    Integer countByCategory(String category);

    // find all courses that start with the provided course name
    List<Course> findByNameStartingWith(String pattern);


    // find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);

    @Query("SELECT c FROM Course c WHERE c.category = :category AND c.rating > :rating")
    List<Course> findAllCByCatgoryAndRatingGreaterThan(@Param("category")String category, @Param("rating")int rating);




}
