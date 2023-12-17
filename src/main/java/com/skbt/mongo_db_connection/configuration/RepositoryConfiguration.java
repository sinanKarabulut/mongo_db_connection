package com.skbt.mongo_db_connection.configuration;

import com.skbt.mongo_db_connection.enums.Gender;
import com.skbt.mongo_db_connection.model.Address;
import com.skbt.mongo_db_connection.model.Student;
import com.skbt.mongo_db_connection.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.Semaphore;

@Configuration
@Slf4j
public class RepositoryConfiguration {

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate){
        Address address = new Address(
                "Turkey",
                "Ankara",
                "06370");
        return args -> {
            String email = "sinan12@sinan.com";
            Student student= new Student(
                    "sinan",
                    "karabulut",
                    email,
                    Gender.MALE,
                    address,
                    List.of("Computer Science"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

            //usingMongoDbTemplateAndQuery(studentRepository, mongoTemplate, email, student);

            studentRepository.findStudentByEmail(email)
                    .ifPresentOrElse(s-> {
                        log.error(s + "  already exists.");
                    }, ()->{
                        log.info("created student");
                        studentRepository.save(student);
                    });
        };
    }

    private static void usingMongoDbTemplateAndQuery(StudentRepository studentRepository, MongoTemplate mongoTemplate, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        List<Student> students = mongoTemplate.find(query, Student.class);

        if(students.size() > 1){
            throw new IllegalStateException("found many students with mail " + email);
        }

        if(students.isEmpty()){
            log.info("created student");
            studentRepository.save(student);
        }else{
            log.error("student already exists.");
        }
    }
}
