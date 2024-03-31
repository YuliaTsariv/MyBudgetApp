package com.example.ProjectTestMySql.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Setter
@Getter
@Document(collection = "budget")
public class Budget {
    @Id
    private Long userId;

    @Field(name = "account")
    private BigDecimal account;

    @PersistenceCreator
    public Budget(Long userId, BigDecimal account) {
        this.userId = userId;
        this.account = account;
    }
}
