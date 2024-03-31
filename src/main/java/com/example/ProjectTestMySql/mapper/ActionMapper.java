package com.example.ProjectTestMySql.mapper;

import com.example.ProjectTestMySql.model.dto.ActionPayload;
import com.example.ProjectTestMySql.model.entity.Action;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActionMapper {

    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    Action toAction(ActionPayload actionPayload);
}
