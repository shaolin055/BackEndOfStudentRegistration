package com.example.backendofstudentregistration.controller;

import com.example.backendofstudentregistration.entity.Student;
import com.example.backendofstudentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    public StudentService service;

    @PostMapping("/addstudent")
    public Student addCourse(@RequestBody Student student) {
        return service.registerStudent(student);
    }

    @PostMapping("/updatecourse")
    public Student updatecourse(@RequestBody int[] a) {
//        System.out.println(a[1]);
        int studentId = a[0], courseId = a[1];
        return service.registerCourse(studentId, courseId);
    }

    @PostMapping("/deletecourse")
    public Student dropCourse(@RequestBody int[] a) {
        int studentId = a[0], courseId = a[1];
        return service.dopCourse(studentId, courseId);
    }

    @GetMapping("/studentcourselist/{studentId}")
    public Student studentCourseList(@PathVariable int studentId) {
        return service.listCourses(studentId);
    }
}


/*


localhost:9191/addstudent/

{
	"name" : "hao",
	"major": "EEE",
	"courseList" : [2,3]
}


localhost:9191/updatecourse
[7,15]

localhost:9191/deletecourse
[7,6]


get

studentcourselist/2


 */