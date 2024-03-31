package com.example.ProjectTestMySql.service;

import com.example.ProjectTestMySql.model.entity.MyBudget;
import com.example.ProjectTestMySql.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderService {

    OrderRepository orderRepository;

    public void createBudget(MyBudget myBudget){
        orderRepository.save(myBudget);
    }
}
