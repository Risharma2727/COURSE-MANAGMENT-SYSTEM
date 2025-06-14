package com.example.courseapp.course_management.controller;

import com.example.courseapp.course_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses-page")
    public String showCoursesPage(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses"; // Loads courses.html from src/main/resources/templates/
    }
}
