package com.example.ProjectTestMySql.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "action")
public class Action {
    @Id
    Long id;

    @Field(name = "type")
    ActionType type;

    @Field(name = "user_id")
    Long userId;

    @Field(name = "date_time")
    String date;

    @Field(name = "amount_of_money")
    BigDecimal amountOfMoney;

    @Field(name = "group_name")
    String groupName;

    @PersistenceCreator
    public Action(Long id, ActionType type, Long userId, String groupName, String dateTime) {
        this.id = id;
        this.type = type;
        this.userId = userId;
        this.groupName = groupName;
        this.date = dateTime;
    }
}
