package com.example.ProjectTestMySql.service;

import com.example.ProjectTestMySql.mapper.GroupMapper;
import com.example.ProjectTestMySql.model.dto.GroupPayload;
import com.example.ProjectTestMySql.model.entity.GroupType;
import com.example.ProjectTestMySql.repository.GroupRepository;
import com.example.ProjectTestMySql.util.RandomGenerator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GroupService {
    GroupRepository groupRepository;
    RandomGenerator randomGenerator;

    public void saveGroup(GroupPayload groupPayload) {
        var group = GroupMapper.INSTANCE.toGroup(groupPayload);
        group.setId(randomGenerator.randomlyGenerateId());
        groupRepository.save(group);
    }

    public List<GroupPayload> searchGroups(Long userId) {
        var groups = groupRepository.findByUserIdOrGroupType(userId, GroupType.PLATFORM);
        return groups.stream().map(GroupMapper.INSTANCE::toGroupPayload).toList();
    }

    @Transactional
    public void updateGroup(GroupPayload groupPayload) {
        var existingBudget = groupRepository.findById(groupPayload.getId()).orElseThrow(EntityNotFoundException::new);
        GroupMapper.INSTANCE.updateGroupFromDto(groupPayload, existingBudget);
    }

    @Transactional
    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
