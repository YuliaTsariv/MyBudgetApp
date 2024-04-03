package com.example.ProjectTestMySql.repository;

import com.example.ProjectTestMySql.model.entity.Action;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends MongoRepository<Action, Long> {
    List<Action> findByUserId(Long userId);
}
