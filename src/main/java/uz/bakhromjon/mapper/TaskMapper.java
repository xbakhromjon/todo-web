package uz.bakhromjon.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhromjon.dto.task.TaskCreateDto;
import uz.bakhromjon.dto.task.TaskDto;
import uz.bakhromjon.dto.task.TaskUpdateDto;
import uz.bakhromjon.entity.task.Task;

/**
 * @author Bakhromjon Fri, 9:23 PM 2/18/2022
 */
@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<
        Task, TaskCreateDto, TaskUpdateDto, TaskDto> {
}
