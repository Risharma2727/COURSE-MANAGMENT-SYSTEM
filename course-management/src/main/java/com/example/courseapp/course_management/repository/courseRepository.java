package com.example.courseapp.course_management.repository;

import com.example.courseapp.course_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface courseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructor(String instructor);
}
