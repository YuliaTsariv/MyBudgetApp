package com.example.ProjectTestMySql.controller;

import com.example.ProjectTestMySql.model.dto.OrderPayload;
import com.example.ProjectTestMySql.model.entity.MyBudget;
import com.example.ProjectTestMySql.service.OrderService;
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
    private final OrderService orderService;


    @CrossOrigin(originPatterns = "*")
    @PostMapping(ORDER)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderPayload orderPayload) {
        log.info("Handle adding order " + orderPayload);
        var dish = new MyBudget();
        dish.setId(1L);
        dish.setTotalWeight(4);
        orderService.createBudget(dish);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @CrossOrigin(originPatterns = "*")
    @GetMapping(ORDER)
    public ResponseEntity<Void> searchOrderByParam() {
        log.info("Handle searching order: " );

        var dish = new MyBudget();
        dish.setId(1L);
        dish.setTotalWeight(4);
        orderService.createBudget(dish);
        return ResponseEntity.status(NO_CONTENT).build();    }
//
//    @CrossOrigin(originPatterns = "*")
//    @PatchMapping(ORDER)
//    public ResponseEntity<Void> partialUpdateOrderConfig(@RequestBody OrderPayload orderPayload) {
//        log.info("Handle update order: " + orderPayload);
//        orderService.partialUpdateOrderConfig(orderPayload);
//        return ResponseEntity.status(NO_CONTENT).build();
//    }
//
//    @CrossOrigin(originPatterns = "*")
//    @DeleteMapping(ORDER)
//    public ResponseEntity<Void> deleteOrder(@RequestParam Long id) {
//        log.info("Handle deleting order with id: " + id);
//        orderService.deleteOrder(id);
//        return ResponseEntity.noContent().build();
//    }
}
