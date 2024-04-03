package com.example.ProjectTestMySql.model.dto;

import com.example.ProjectTestMySql.model.entity.ActionType;
import com.example.ProjectTestMySql.util.DateTimeDeserializer;
import com.example.ProjectTestMySql.util.DateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
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
    OffsetDateTime date;

    String groupName;
}
