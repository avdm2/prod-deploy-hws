package com.avdm2.mapper;

import com.avdm2.dto.TaskDTO;
import com.avdm2.entity.TaskEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntity convert(TaskDTO t);
    TaskDTO convert(TaskEntity t);
    List<TaskDTO> convert(List<TaskEntity> t);
}
