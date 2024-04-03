package com.example.ProjectTestMySql.mapper;

import com.example.ProjectTestMySql.model.dto.GroupPayload;
import com.example.ProjectTestMySql.model.entity.Group;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    Group toGroup(GroupPayload groupPayload);

    GroupPayload toGroupPayload(Group group);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateGroupFromDto(GroupPayload groupPayload, @MappingTarget Group group);
}
