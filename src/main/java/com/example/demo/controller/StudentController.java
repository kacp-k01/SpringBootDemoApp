package com.example.demo.controller;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.student.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/allStudents")
    public List<Student> getStudents() {
        List<Student> allStudents = studentService.getStudents();

        if (allStudents.isEmpty())
            throw new ApiRequestException("No students to Show");
        else return allStudents;
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

}
