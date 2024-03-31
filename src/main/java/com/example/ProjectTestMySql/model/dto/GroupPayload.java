package com.example.ProjectTestMySql.model.dto;

import com.example.ProjectTestMySql.model.entity.GroupType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupPayload {
    Long id;

    String name;

    GroupType groupType;

    Long userId;
}
