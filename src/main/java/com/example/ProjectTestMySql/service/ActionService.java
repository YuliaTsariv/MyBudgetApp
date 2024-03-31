package com.example.ProjectTestMySql.service;

import com.example.ProjectTestMySql.mapper.ActionMapper;
import com.example.ProjectTestMySql.model.dto.ActionPayload;
import com.example.ProjectTestMySql.model.entity.Action;
import com.example.ProjectTestMySql.model.entity.Budget;
import com.example.ProjectTestMySql.repository.ActionRepository;
import com.example.ProjectTestMySql.repository.BudgetRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ActionService {
    ActionRepository actionRepository;
    BudgetRepository budgetRepository;
    Random random = new Random();

    public Action createAction(ActionPayload actionPayload) {
        var dateTime = actionPayload.getDateTime().toString();
        var action = ActionMapper.INSTANCE.toAction(actionPayload, dateTime);
        Optional<Budget> existingBudget = budgetRepository.findByUserId(actionPayload.getUserId());
        if (existingBudget.isPresent()) {
            Budget budget = existingBudget.get();
            budget.setAccount(BigDecimal.TEN);
            budgetRepository.save(budget);
        } else {
            Budget newBudget = new Budget();
            newBudget.setUserId(actionPayload.getUserId());
            newBudget.setAccount(BigDecimal.ONE);
            budgetRepository.save(newBudget);
        }
        var id = random.nextLong();
        action.setId(id);
        return actionRepository.save(action);
    }
}
