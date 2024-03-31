package com.example.ProjectTestMySql.service;

import com.example.ProjectTestMySql.mapper.ActionMapper;
import com.example.ProjectTestMySql.model.dto.ActionPayload;
import com.example.ProjectTestMySql.model.entity.Action;
import com.example.ProjectTestMySql.repository.ActionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ActionService {
    ActionRepository actionRepository;
    Random random = new Random();

    public Action createAction(ActionPayload actionPayload) {
        var action = ActionMapper.INSTANCE.toAction(actionPayload);
        actionRepository.count();
        var id = random.nextLong();
        action.setId(id);
        System.out.println("we here");
        return actionRepository.save(action);
    }
}
