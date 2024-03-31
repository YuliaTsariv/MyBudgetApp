package com.example.ProjectTestMySql.model.entity;


import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Setter
@Document(collection = "budget")
public class Budget {
    @Id
    private Long userId;

    @Field(name = "account")
    private BigDecimal account;
}
