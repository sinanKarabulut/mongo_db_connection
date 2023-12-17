package com.skbt.mongo_db_connection.service;

import com.skbt.mongo_db_connection.model.Student;
import com.skbt.mongo_db_connection.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService{
    private final StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
