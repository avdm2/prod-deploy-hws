package com.avdm2.service;

import com.avdm2.dto.TaskDTO;
import com.avdm2.mapper.TaskMapper;
import com.avdm2.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public Flux<TaskDTO> findAll() {
        return taskRepository.findAll().map(taskMapper::convert);
    }

    public Mono<Integer> addTask(TaskDTO taskDTO) {
        return taskRepository.save(taskMapper.convert(taskDTO).withCreatedAt(LocalDateTime.now())).thenReturn(taskDTO.getId());
    }
}
