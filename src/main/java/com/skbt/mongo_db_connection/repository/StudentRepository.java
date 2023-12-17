package com.skbt.mongo_db_connection.repository;

import com.skbt.mongo_db_connection.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);
}
