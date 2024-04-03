package com.example.ProjectTestMySql.service;

import com.example.ProjectTestMySql.mapper.ActionMapper;
import com.example.ProjectTestMySql.model.dto.ActionPayload;
import com.example.ProjectTestMySql.model.dto.SearchActionRequest;
import com.example.ProjectTestMySql.model.entity.Action;
import com.example.ProjectTestMySql.model.entity.ActionType;
import com.example.ProjectTestMySql.model.entity.Budget;
import com.example.ProjectTestMySql.repository.ActionRepository;
import com.example.ProjectTestMySql.repository.BudgetRepository;
import com.example.ProjectTestMySql.util.RandomGenerator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ActionService {
    ActionRepository actionRepository;
    BudgetRepository budgetRepository;
    BudgetService budgetService;
    RandomGenerator randomGenerator;

    public Action createAction(ActionPayload actionPayload) {
        var dateTime = actionPayload.getDate().toString();
        var action = ActionMapper.INSTANCE.toAction(actionPayload, dateTime);
        action.setDate(dateTime);
        handleUpdatingBudget(actionPayload);
        action.setId(randomGenerator.randomlyGenerateId());
        return actionRepository.save(action);
    }

    public List<ActionPayload> searchActions(SearchActionRequest searchActionRequest) {
        var dateTime = searchActionRequest.getDateTime();
        var userId = searchActionRequest.getUserId();
        var actions = actionRepository.findByUserId(userId);
        return actions.stream()
                .filter(isOccurInDateRange(dateTime, dateTime.plusDays(1)))
                .map(a -> ActionMapper.INSTANCE.toActionPayload(a, extractDateTime(a)))
                .toList();
    }

    @Transactional
    public void deleteAction(Long actionId) {
        actionRepository.deleteById(actionId);
    }

    private void handleUpdatingBudget(ActionPayload actionPayload) {
        Optional<Budget> existingBudget = budgetRepository.findByUserId(actionPayload.getUserId());
        if (existingBudget.isPresent()) {
            Budget budget = existingBudget.get();
            budget.setAccount(getNewBalance(actionPayload, budget));
            budgetService.saveBudget(budget);
        } else {
            budgetService.saveBudget(new Budget(actionPayload.getUserId(), BigDecimal.ONE));
        }
    }

    private BigDecimal getNewBalance(ActionPayload actionPayload, Budget budget) {
        var actionType = actionPayload.getType();
        if (actionType.equals(ActionType.EXPENSES)) {
            return budget.getAccount().subtract(actionPayload.getAmountOfMoney());
        } else {
            return budget.getAccount().add(actionPayload.getAmountOfMoney());
        }
    }

    private Predicate<? super Action> isOccurInDateRange(OffsetDateTime startDate, OffsetDateTime endDate) {
        return action -> {
            var dateTime = extractDateTime(action);
            return dateTime.isAfter(startDate) && dateTime.isBefore(endDate);
        };
    }

    private OffsetDateTime extractDateTime(Action action) {
        return OffsetDateTime.parse(action.getDate());
    }
}
