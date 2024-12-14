package com.avdm2.service;

import com.avdm2.dto.TaskDTO;
import com.avdm2.mapper.TaskMapper;
import com.avdm2.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public Flux<TaskDTO> findAll() {
        return taskRepository.findAll().map(taskMapper::convert);
    }

    public Mono<TaskDTO> findByUuid(UUID uuid) {
        return taskRepository.findByUuid(uuid).map(taskMapper::convert);
    }

    public Mono<UUID> addTask(TaskDTO taskDTO) {
        return taskRepository.save(taskMapper.convert(taskDTO)).thenReturn(taskDTO.getUuid());
    }
}
