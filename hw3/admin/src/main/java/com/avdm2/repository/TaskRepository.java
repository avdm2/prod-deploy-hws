package com.avdm2.repository;

import com.avdm2.entity.TaskEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TaskRepository extends ReactiveCrudRepository<TaskEntity, Integer> {
}
