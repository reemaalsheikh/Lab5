package com.example.lab5q1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//Student : name, age, degree,status, array of students.
public class Student {

private String name;
private int age;
private double degree;
private String status;

}
