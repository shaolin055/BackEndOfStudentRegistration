package com.example.backendofstudentregistration.service;

import com.example.backendofstudentregistration.entity.Course;
import com.example.backendofstudentregistration.entity.Student;
import com.example.backendofstudentregistration.repository.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    static Logger logger = Logger.getLogger(CourseService.class);
    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public CourseService courseService;

    //    PostAPI
    public Student registerStudent(Student student) {
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            logger.error("Database error when deleting course for student: " + student.getName() + ", error: " + e.getMessage());
            return null;
        }

    }

    public Student registerCourse(int studentId, int courseId) {
        Student student = null;
        try {
            student = studentRepository.findById(studentId).orElse(null);
        } catch (Exception e) {
            logger.error("Database error when fetcing course for student: " + studentId + ", error: " + e.getMessage());
        }

        List<Course> course = courseService.getCourses();

//        System.out.println(student);

        boolean courseInList = false;

        for (Course i : course) {
            if (i.getId() == courseId) {
                courseInList = true;
                break;
            }
        }

        try {
            if (student != null && courseInList) {
                ArrayList<Integer> listOfCourse = student.getCourseList();
                if (listOfCourse.isEmpty()) {
                    listOfCourse.add(courseId);
                    student.setCourseList(listOfCourse);
                    return studentRepository.save(student);
                } else {
                    if (listOfCourse.contains(courseId)) {
                        return null;
                    } else {
                        listOfCourse.add(courseId);
                        student.setCourseList(listOfCourse);
                        return studentRepository.save(student);
//        student.setName(existingStudentData.getName());
//        return studentRepository.save(student);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Database error when registering course for student: " + studentId + ", error: " + e.getMessage());
        }
        return null;
//        student.setCourseList(existingStudentData.getCourseList());
//        student.setName(existingStudentData.getName());
//        return studentRepository.save(student);
    }

    public Student listCourses(int studentId) {
        try {
            return studentRepository.findById(studentId).orElse(null);
        } catch (Exception e) {
            logger.error("Database error when listing student id: " + studentId + ", error:" + e.getMessage());
            return null;
        }
    }

    public Student dopCourse(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        List<Course> course = courseService.getCourses();

        System.out.println(student);

        boolean courseInList = false;

        for (Course i : course) {   //Check if course is in the list of courses or not.
            if (i.getId() == courseId) {
                courseInList = true;
                break;
            }

        }

        try {
            if (student != null && courseInList) {  //Check if the student is valid and have records
                ArrayList<Integer> listOfCourse = student.getCourseList();
                if (listOfCourse.isEmpty()) {  // Check if student has no course
                    return null;
                } else {
                    if (listOfCourse.contains(courseId)) {
                        listOfCourse.remove(listOfCourse.stream().filter(i -> i == courseId).toArray()[0]);
                        student.setCourseList(listOfCourse);
                        return studentRepository.save(student);
                    } else {
                        return null;
//        student.setName(existingStudentData.getName());
//        return studentRepository.save(student);
                    }
                }

            }
        } catch (Exception e) {
            logger.error("Database error when droping course for student: " + studentId + ", error: " + e.getMessage());
        }
        return null;
    }

}


