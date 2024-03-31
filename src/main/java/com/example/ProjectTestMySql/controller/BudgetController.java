package com.example.ProjectTestMySql.controller;

import com.example.ProjectTestMySql.model.dto.OrderPayload;
import com.example.ProjectTestMySql.model.entity.Budget;
import com.example.ProjectTestMySql.service.BudgetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.ProjectTestMySql.controller.BudgetController.API;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequestMapping(API)
@RestController
@RequiredArgsConstructor
@Slf4j
public class BudgetController {
    public static final String API = "/api/budget";

    public static final String ORDER = "/order";
    private final BudgetService budgetService;


    @CrossOrigin(originPatterns = "*")
    @PostMapping(ORDER)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderPayload orderPayload) {
        log.info("Handle adding order " + orderPayload);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @CrossOrigin(originPatterns = "*")
    @GetMapping(ORDER)
    public ResponseEntity<Void> searchOrderByParam() {
        log.info("Handle searching order: " );

        var dish = new Budget();

        budgetService.createBudget(dish);
        return ResponseEntity.status(NO_CONTENT).build();    }
}
