package com.example.ProjectTestMySql.model.dto;

import com.example.ProjectTestMySql.model.entity.ActionType;
import com.example.ProjectTestMySql.util.DateTimeDeserializer;
import com.example.ProjectTestMySql.util.DateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActionPayload {
    Long id;

    ActionType type;

    Long userId;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    @JsonSerialize(using = DateTimeSerializer.class)
    OffsetDateTime dateTime;

    String groupName;
}
