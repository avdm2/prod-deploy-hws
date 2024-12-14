package com.avdm2.controller;

import com.avdm2.dto.TaskDTO;
import com.avdm2.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/all")
    public Mono<ResponseEntity<List<TaskDTO>>> findAll() {
        return taskService.findAll().collectList().map(ResponseEntity::ok);
    }

    @GetMapping("/{uuid}")
    public Mono<ResponseEntity<TaskDTO>> findByUuid(@PathVariable UUID uuid) {
        return taskService.findByUuid(uuid).map(ResponseEntity::ok);
    }

    @PostMapping("/add")
    public Mono<ResponseEntity<UUID>> addTask(@RequestBody TaskDTO task) {
        return taskService.addTask(task).map(ResponseEntity::ok);
    }
}
