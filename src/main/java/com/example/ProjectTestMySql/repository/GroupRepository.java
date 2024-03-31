package com.example.ProjectTestMySql.repository;

import com.example.ProjectTestMySql.model.entity.Group;
import com.example.ProjectTestMySql.model.entity.GroupType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends MongoRepository<Group, Long> {
    List<Group> findByUserIdOrGroupType(Long userId, GroupType groupType);
}
