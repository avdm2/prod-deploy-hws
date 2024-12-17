package com.avdm2.controller;

import com.avdm2.dto.TaskDTO;
import com.avdm2.mapper.TaskMapper;
import com.avdm2.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @PostMapping("/add")
    public Mono<ResponseEntity<TaskDTO>> addTask(@RequestBody TaskDTO task) {
        return taskRepository
                .save(taskMapper.convert(task
                        .withCreatedAt(LocalDateTime.now())
                        .withOwnerUsername("admin")))
                .map(taskMapper::convert)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Integer>> removeTask(@PathVariable Integer id) {
        return taskRepository.deleteById(id).thenReturn(1).map(ResponseEntity::ok);
    }

}
