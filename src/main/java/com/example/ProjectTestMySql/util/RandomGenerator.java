package com.example.ProjectTestMySql.util;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomGenerator {
    Random random = new Random();
    public Long randomlyGenerateId(){
        return Math.abs(random.nextLong());
    }
}
