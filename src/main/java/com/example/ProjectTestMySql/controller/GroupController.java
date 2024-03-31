package com.example.ProjectTestMySql.controller;

import com.example.ProjectTestMySql.model.dto.GroupPayload;
import com.example.ProjectTestMySql.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.ProjectTestMySql.controller.ActionController.API;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequestMapping(API)
@RestController
@RequiredArgsConstructor
@Slf4j
public class GroupController {
    public static final String GROUP = "/group";
    private final GroupService groupService;

    @GetMapping(GROUP)
    public ResponseEntity<List<GroupPayload>> searchCriteria(@RequestParam Long userId) {
        return ResponseEntity.ok(groupService.searchGroups(userId));
    }

    @PostMapping(GROUP)
    public ResponseEntity<Void> saveGroup(@RequestBody GroupPayload groupPayload) {
        log.info("Handle adding group request: " + groupPayload);
        groupService.saveGroup(groupPayload);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(GROUP)
    public ResponseEntity<Void> updateGroup(@RequestBody GroupPayload groupPayload) {
        log.info("Handle updating group request: " + groupPayload);
        groupService.updateGroup(groupPayload);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @DeleteMapping(GROUP)
    public ResponseEntity<Void> deleteGroup(@RequestParam Long id) {
        log.info("Handle deleting group with id: " + id);
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
