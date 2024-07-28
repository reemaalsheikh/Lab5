package com.example.lab5q1.Controller;

import com.example.lab5q1.Api.ApiResponse;
import com.example.lab5q1.Model.Student;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    //CRUD : Create (post), Read (get), update (put), Delete (delete).
    //1.Create (post) >> add student
    @PostMapping("/add")
    public ApiResponse CreateStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Student successfully added!");
    }

    //2.Read (get)
    // return array of students
    @GetMapping("/get/students")
    public ArrayList<Student> getStudents() {
        return students;
    }

    //3.Update (put)
    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("Student successfully updated!");
    }

    // 4.Delete (delete).
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("Student successfully deleted!");
    }

    //- GET /name : return name of student

    @GetMapping("/get/name/{index}")
    public ApiResponse getStudentnName(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            return new ApiResponse("Student name successfully retrieved! Name: " + student.getName());
        }
        return new ApiResponse("Student name not found!");
    }

    //- GET /age : return age of student

    @GetMapping("/get/age/{index}")
    public ApiResponse getStudentAge(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            return new ApiResponse("Student age successfully retrieved! Age: " + student.getAge());
        }
        return new ApiResponse("Student not found!");
    }
    //- GET / college/degree: return bachelor or diploma or master

    @GetMapping("/get/degree/{index}")
    public ApiResponse getStudentDegree(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            return new ApiResponse("Student degree successfully retrieved! Degree: " + student.getDegree());
        }
        return new ApiResponse("Student not found!");
    }


    //- GET / study/status: return true if graduated and false if ungraduated
    @GetMapping("/status/{index}")
    public ApiResponse getStudentStatus(@PathVariable int index) {
        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            if (student.getStatus().equalsIgnoreCase("Graduated")) {
                return new ApiResponse("Student found!  " + " Status: true");
            }}
            return new ApiResponse("Student found!  " + " Status: False");
    }

}