package com.skbt.mongo_db_connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class  MongoDbConnectionApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MongoDbConnectionApplication.class);
        application.run(args);

    }

}
