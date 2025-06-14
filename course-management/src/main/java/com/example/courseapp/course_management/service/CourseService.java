package com.example.courseapp.course_management.service;

import com.example.courseapp.course_management.entity.Course;
import com.example.courseapp.course_management.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private courseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    public List<Course> getCoursesByInstructor(String instructor) {
        return courseRepository.findByInstructor(instructor);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    
    public Course updateCourse(Long id, Course courseDetails) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(courseDetails.getName());
                    course.setDuration(courseDetails.getDuration());
                    course.setInstructor(courseDetails.getInstructor());
                    return courseRepository.save(course);
                }).orElse(null);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    
}
