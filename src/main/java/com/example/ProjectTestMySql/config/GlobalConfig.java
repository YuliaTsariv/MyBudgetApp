package com.example.ProjectTestMySql.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.Clock;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

@Configuration
@EnableWebMvc
@EnableScheduling
public class GlobalConfig {

    public static final ObjectMapper OBJECT_MAPPER;

    public static final DateTimeFormatter DATE_TIME_FORMATTER = ISO_OFFSET_DATE_TIME;

    static {
        OBJECT_MAPPER = new ObjectMapper();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ObjectMapper mapper() {
        return OBJECT_MAPPER;
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
