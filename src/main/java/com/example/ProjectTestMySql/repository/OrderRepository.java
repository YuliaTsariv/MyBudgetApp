package com.example.ProjectTestMySql.repository;

import com.example.ProjectTestMySql.model.entity.MyBudget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<MyBudget, Long> {
}
