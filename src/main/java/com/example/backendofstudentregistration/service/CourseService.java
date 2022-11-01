package com.example.backendofstudentregistration.service;

import com.example.backendofstudentregistration.entity.Course;
import com.example.backendofstudentregistration.repository.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    static Logger logger = Logger.getLogger(CourseService.class);
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
        Course ret = null;
        try {
            ret = repository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println();
            logger.error("Database error: " + e.getMessage());

        }
        return ret;
    }

    public Course getCoursebyName(String name) {
        Course ret = null;
        try {
            ret = repository.findByname(name);
        } catch (Exception e) {
            System.out.println("Error in database query");
            logger.error("Database error: " + e.getMessage());
        }
        return ret;
    }

    public List<Course> getCourses() {

        List<Course> list = null;
        try {
            list = repository.findAll();
        } catch (Exception e) {
            logger.error("Database error: " + e.getMessage());
        }

        return list;
    }

    public String deleteProduct(int id) {

        try {
            repository.deleteById(id);
        } catch (Exception e) {
            logger.error("Database error when deleting course: " + e.getMessage());
            return e.getMessage();
        }

        return "Product " + id + " deleted";
    }

    public Course updateCourse(Course course) {

        try {
            Course existingCourse = repository.findById(course.getId()).orElse(null);
            existingCourse.setName(course.getName());
            existingCourse.setDepartment(course.getDepartment());
            return repository.save(existingCourse);
        } catch (Exception e) {
            logger.error("Database error when updating course: " + course.getName() + ", error: " + e.getMessage());
            return null;
        }

    }
}