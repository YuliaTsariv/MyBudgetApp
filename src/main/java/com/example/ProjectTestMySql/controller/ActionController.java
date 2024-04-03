package com.example.ProjectTestMySql.controller;

import com.example.ProjectTestMySql.model.dto.ActionPayload;
import com.example.ProjectTestMySql.model.dto.SearchActionRequest;
import com.example.ProjectTestMySql.model.entity.Action;
import com.example.ProjectTestMySql.service.ActionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @CrossOrigin(originPatterns = "*")
    @GetMapping(ACTION)
    public ResponseEntity<List<ActionPayload>> getAction(SearchActionRequest searchActionRequest) {
        log.info("Handle search action request: " + searchActionRequest);
        var actions = actionService.searchActions(searchActionRequest);
        return ResponseEntity.ok(actions);
    }

    @DeleteMapping(ACTION)
    public ResponseEntity<Void> deleteAction(@RequestParam Long id) {
        log.info("Handle deleting group with id: " + id);
        actionService.deleteAction(id);
        return ResponseEntity.noContent().build();
    }
}
