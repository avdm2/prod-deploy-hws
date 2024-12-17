package com.avdm2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Table("tasks")
public class TaskEntity {

    @Id
    private Integer id;

    private String title;

    private String description;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("owner_username")
    private String ownerUsername;
}