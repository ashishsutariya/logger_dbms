package com.dbms.project1.v1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dbms.project1.v1.model.Student;
import com.dbms.project1.v1.repository.StudentRepository;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        System.out.println("here=================================");
        
        return studentRepository.findAll();
        
    }
    
    @PostMapping("/deletestudents/{bNumber}")
    public String deleteStudentByBNumber(@PathVariable String bNumber) {
        return studentRepository.deletestudent(bNumber);
    }

}
