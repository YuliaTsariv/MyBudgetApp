package com.example.ProjectTestMySql.model.entity;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Document(collation = "action")
public class Action {
    @Id
    Long id;

    @Field(name = "type")
    ActionType type;

    @Field(name = "user_id")
    Long userId;

//    @Field(name = "dateTime")
//    OffsetDateTime dateTime;

    @Field(name = "group_name")
    String groupName;

    @PersistenceCreator
    public Action(Long id, ActionType type, Long userId, String groupName) {
        this.id = id;
        this.type = type;
        this.userId = userId;
        this.groupName = groupName;
    }
}
