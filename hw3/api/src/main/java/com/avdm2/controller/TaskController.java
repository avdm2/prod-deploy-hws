package com.avdm2.controller;

import com.avdm2.dto.TaskDTO;
import com.avdm2.mapper.TaskMapper;
import com.avdm2.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @GetMapping("/all")
    public Mono<ResponseEntity<List<TaskDTO>>> findAll() {
        return taskRepository.findAll()
                .collectList()
                .map(taskMapper::convert)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/user/{username}")
    public Mono<ResponseEntity<List<TaskDTO>>> findByUsername(@PathVariable String username) {
        return taskRepository.findAllByOwnerUsername(username)
                .collectList()
                .map(taskMapper::convert)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/id/{id}")
    public Mono<ResponseEntity<TaskDTO>> getById(@PathVariable Integer id) {
        return taskRepository.findById(id)
                .map(taskMapper::convert)
                .map(ResponseEntity::ok);
    }

    @PostMapping("/add")
    public Mono<ResponseEntity<TaskDTO>> addTask(@RequestBody TaskDTO task) {
        return "admin".equals(task.getOwnerUsername())
                ? Mono.just(ResponseEntity.badRequest().build())
                : taskRepository.save(taskMapper.convert(task.withCreatedAt(LocalDateTime.now())))
                .map(taskMapper::convert)
                .map(ResponseEntity::ok);
    }

}
