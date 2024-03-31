package com.example.ProjectTestMySql.model.dto;

import com.example.ProjectTestMySql.model.entity.ActionType;
import com.example.ProjectTestMySql.util.DateTimeDeserializer;
import com.example.ProjectTestMySql.util.DateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionPayload {
    Long id;

    ActionType type;

    Long userId;

    BigDecimal amountOfMoney;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @JsonSerialize(using = DateTimeSerializer.class)
    OffsetDateTime dateTime;

    String groupName;
}
