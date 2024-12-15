package com.avdm2.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {

    private Integer id;

    private String title;

    private String description;

    private LocalDateTime createdAt;
}
