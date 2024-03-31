package com.example.ProjectTestMySql.controller;

import com.example.ProjectTestMySql.model.dto.ActionPayload;
import com.example.ProjectTestMySql.model.entity.Action;
import com.example.ProjectTestMySql.service.ActionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.ProjectTestMySql.controller.ActionController.API;
import static org.springframework.http.HttpStatus.NO_CONTENT;


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

    @PatchMapping(ACTION)
    public ResponseEntity<Void> updateAction(@RequestBody ActionPayload actionPayload) {
        log.info("Handle updating action request: " + actionPayload);
        actionService.updateAction(actionPayload);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @DeleteMapping(ACTION)
    public ResponseEntity<Void> deleteAction(@RequestParam Long id) {
        log.info("Handle deleting group with id: " + id);
        actionService.deleteAction(id);
        return ResponseEntity.noContent().build();
    }
}
