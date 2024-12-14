package com.avdm2.mapper;

import com.avdm2.dto.TaskDTO;
import com.avdm2.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO convert(TaskEntity taskEntity);
    TaskEntity convert(TaskDTO taskDTO);
}
