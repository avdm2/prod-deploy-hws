package com.avdm2.repository;

import com.avdm2.entity.TaskEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TaskRepository extends R2dbcRepository<TaskEntity, UUID> {

    Mono<TaskEntity> findByUuid(UUID uuid);
}
