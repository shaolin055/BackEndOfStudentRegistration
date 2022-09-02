package com.example.backendofstudentregistration.repository;

import com.example.backendofstudentregistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}