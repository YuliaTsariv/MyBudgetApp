package com.example.ProjectTestMySql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableMongoRepositories("com.example.ProjectTestMySql.repository")
public class MyBudgetAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBudgetAppApplication.class, args);
    }
}
