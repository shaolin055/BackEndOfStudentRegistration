package com.example.backendofstudentregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student")

public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String major;
    private ArrayList<Integer> courseList;
//    private boolean availibility;
//    private String instructor;
}
