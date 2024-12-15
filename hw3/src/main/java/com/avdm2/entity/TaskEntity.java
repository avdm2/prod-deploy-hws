package com.avdm2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@With
@AllArgsConstructor
@Table("tasks")
public class TaskEntity {

    private Integer id;

    private String title;

    private String description;

    @Column("created_at")
    private LocalDateTime createdAt;
}
