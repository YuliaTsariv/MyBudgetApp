package com.example.ProjectTestMySql.controller;

import com.example.ProjectTestMySql.model.dto.BudgetPayload;
import com.example.ProjectTestMySql.service.BudgetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.ProjectTestMySql.controller.ActionController.API;

@RequestMapping(API)
@RestController
@RequiredArgsConstructor
@Slf4j
public class BudgetController {
    private static final String GET = "/get";
    private final BudgetService budgetService;


    @CrossOrigin(originPatterns = "*")
    @GetMapping(GET)
    public ResponseEntity<BudgetPayload> getBudget(@RequestParam Long userId) {
        log.info("Handle search budget for user with id : " + userId);
        var budget = budgetService.getBudget(userId);
        return ResponseEntity.ok(budget);
    }
}
