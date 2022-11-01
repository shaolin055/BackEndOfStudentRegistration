package com.example.backendofstudentregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//https://www.youtube.com/watch?v=IucFDX3RO9U

@SpringBootApplication
@EnableWebSecurity
public class BackEndOfStudentRegistrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackEndOfStudentRegistrationApplication.class, args);
    }
}