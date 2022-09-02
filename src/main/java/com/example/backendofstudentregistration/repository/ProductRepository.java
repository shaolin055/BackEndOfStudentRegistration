package com.example.backendofstudentregistration.repository;

import com.example.backendofstudentregistration.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Course,Integer> {

    Course findByname(String name);
}
