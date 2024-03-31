package com.example.ProjectTestMySql.service;

import com.example.ProjectTestMySql.model.entity.Budget;
import com.example.ProjectTestMySql.repository.BudgetRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BudgetService {

    BudgetRepository budgetRepository;

    public void createBudget(Budget myBudget){
        budgetRepository.save(myBudget);
    }
}
