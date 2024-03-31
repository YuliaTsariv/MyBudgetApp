package com.example.ProjectTestMySql.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "group")
public class Group {
    @Id
    Long id;

    String name;

    @Field(name = "group_type")
    GroupType groupType;

    @Field(name = "user_id")
    Long userId;
}
