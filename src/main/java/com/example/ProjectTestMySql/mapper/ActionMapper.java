package com.example.ProjectTestMySql.mapper;

import com.example.ProjectTestMySql.model.dto.ActionPayload;
import com.example.ProjectTestMySql.model.entity.Action;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActionMapper {

    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    @Mapping(target = "dateTime", source = "dateTime")
    @Mapping(target = "id", source = "actionPayload.id")
    @Mapping(target = "type", source = "actionPayload.type")
    @Mapping(target = "userId", source = "actionPayload.userId")
    @Mapping(target = "groupName", source = "actionPayload.groupName")
    Action toAction(ActionPayload actionPayload, String dateTime);
}
