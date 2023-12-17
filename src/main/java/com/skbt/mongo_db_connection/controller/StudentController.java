package com.skbt.mongo_db_connection.controller;

import com.skbt.mongo_db_connection.model.Student;
import com.skbt.mongo_db_connection.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @GetMapping(value = "fetchAllStudents")
    public ResponseEntity<List<Student>> fetchAllStudents(){
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }
}
