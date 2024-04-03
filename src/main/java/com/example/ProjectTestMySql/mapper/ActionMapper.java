package com.example.ProjectTestMySql.mapper;

import com.example.ProjectTestMySql.model.dto.ActionPayload;
import com.example.ProjectTestMySql.model.entity.Action;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;

@Mapper(componentModel = "spring")
public interface ActionMapper {

    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    @Mapping(target = "id", source = "actionPayload.id")
    @Mapping(target = "type", source = "actionPayload.type")
    @Mapping(target = "userId", source = "actionPayload.userId")
    @Mapping(target = "groupName", source = "actionPayload.groupName")
    @Mapping(target = "date", source = "dateTime")
    Action toAction(ActionPayload actionPayload, String dateTime);

    @Mapping(target = "date", source = "date")
    ActionPayload toActionPayload(Action action, OffsetDateTime date);
}
