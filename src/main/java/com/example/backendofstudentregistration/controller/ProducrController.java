package com.example.backendofstudentregistration.controller;

import com.example.backendofstudentregistration.entity.Course;
import com.example.backendofstudentregistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class ProducrController {

    @Autowired
    public CourseService service;

    @PostMapping("/addcourse")
    public Course addCourse(@RequestBody Course course) {
        return service.seveCourse(course);
    }

    @PostMapping("/addcourses")
    public List<Course> addCourses(@RequestBody List<Course> course) {
        return service.saveCourses(course);
    }

    @GetMapping("/getcourse/{id}")
    public Course getcourse(@PathVariable int id) {
        return service.getCoursebyId(id);
    }

//    @GetMapping("/getallstudents")
//    public

    @GetMapping("/courses")
    public List<Course> listOfCourses() {
        return service.getCourses();
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return service.updateCourse(course);
    }

    @DeleteMapping("/deletecourse/{id}")
    public String deleteCouse(@PathVariable int id) {
        return service.deleteProduct(id);
    }

}


/*
localhost:9191/courses


 */