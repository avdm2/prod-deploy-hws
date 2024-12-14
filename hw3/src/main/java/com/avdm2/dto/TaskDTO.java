package com.avdm2.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TaskDTO {

    private UUID uuid;

    private String title;

    private String description;

    private LocalDateTime createdAt;
}
