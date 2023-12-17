package com.skbt.mongo_db_connection.service;

import com.skbt.mongo_db_connection.model.Student;

import java.util.List;

public interface IStudentService {

    /**
     * @return
     */
    List<Student> getAllStudents();
}
