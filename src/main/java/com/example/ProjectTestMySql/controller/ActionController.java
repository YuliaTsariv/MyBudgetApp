package com.example.ProjectTestMySql.controller;

import com.example.ProjectTestMySql.model.dto.ActionPayload;
import com.example.ProjectTestMySql.model.entity.Action;
import com.example.ProjectTestMySql.service.ActionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.ProjectTestMySql.controller.ActionController.API;


@RequestMapping(API)
@RestController
@RequiredArgsConstructor
@Slf4j
public class ActionController {
    public static final String API = "/api/budget";

    private final ActionService actionService;

    public static final String ACTION = "/action";


    @CrossOrigin(originPatterns = "*")
    @PostMapping(ACTION)
    public ResponseEntity<Action> saveAction(@RequestBody ActionPayload actionPayload) {
        log.info("Handle adding action request: " + actionPayload);
        var action = actionService.createAction(actionPayload);
        return ResponseEntity.ok(action);
    }
}
