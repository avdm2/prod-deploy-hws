package com.avdm2.repository;

import com.avdm2.entity.TaskEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TaskRepository extends R2dbcRepository<TaskEntity, Integer> {
}
