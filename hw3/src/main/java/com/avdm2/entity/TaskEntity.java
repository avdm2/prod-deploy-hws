package com.avdm2.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("tasks")
@Builder
@Data
public class TaskEntity {

    @Id
    private UUID uuid;

    private String title;

    private String description;

    @Column("created_at")
    private LocalDateTime createdAt;
}
