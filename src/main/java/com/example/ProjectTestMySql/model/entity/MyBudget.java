package com.example.ProjectTestMySql.model.entity;


import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Document(collation = "myBudget")
public class MyBudget {
    @Id
    private Long id;

    @Field(name = "total_weight_id")
    private Integer totalWeight;
}
