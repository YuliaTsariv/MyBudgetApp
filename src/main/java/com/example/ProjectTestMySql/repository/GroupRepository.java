package com.example.ProjectTestMySql.repository;

import com.example.ProjectTestMySql.model.entity.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, Long> {
}
