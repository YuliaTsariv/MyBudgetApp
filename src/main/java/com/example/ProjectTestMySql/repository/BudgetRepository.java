package com.example.ProjectTestMySql.repository;

import com.example.ProjectTestMySql.model.entity.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BudgetRepository extends MongoRepository<Budget, Long> {
    Optional<Budget> findByUserId(Long userId);
}
