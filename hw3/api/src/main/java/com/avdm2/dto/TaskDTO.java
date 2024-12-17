package com.avdm2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDateTime;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Integer id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private String ownerUsername;
}
