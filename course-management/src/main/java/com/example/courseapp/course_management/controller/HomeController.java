package com.example.courseapp.course_management.controller;

import com.example.courseapp.course_management.entity.Course;
import com.example.courseapp.course_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "index"; // Loads index.html from src/main/resources/templates/
    }
    @PostMapping
public Course createCourse(@ModelAttribute Course course) {
    return courseService.saveCourse(course);
}

}
