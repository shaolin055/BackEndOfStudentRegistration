package com.example.backendofstudentregistration.service;

import com.example.backendofstudentregistration.entity.Course;
import com.example.backendofstudentregistration.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private ProductRepository repository;

    //    PostAPI
    public Course seveCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> saveCourses(List<Course> courses) {
        return repository.saveAll(courses);
    }

    //    Get Call
    public Course getCoursebyId(int id) {
        return repository.findById(id).orElse(null);
    }

    public Course getCoursebyName(String name) {
        return repository.findByname(name);
    }

    public List<Course> getCourses() {
        return repository.findAll();
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "Product " + id + " deleted";
    }

    public Course updateCourse(Course course) {
        Course existingCourse = repository.findById(course.getId()).orElse(null);
        existingCourse.setName(course.getName());
        existingCourse.setDepartment(course.getDepartment());
        return repository.save(existingCourse);
    }
}