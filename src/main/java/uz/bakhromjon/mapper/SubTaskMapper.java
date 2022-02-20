package uz.bakhromjon.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhromjon.dto.task.SubTaskCreateDto;
import uz.bakhromjon.dto.task.SubTaskDto;
import uz.bakhromjon.dto.task.SubTaskUpdateDto;
import uz.bakhromjon.entity.task.SubTask;

/**
 * @author Bakhromjon Fri, 9:24 PM 2/18/2022
 */
@Mapper(componentModel = "spring")
public interface SubTaskMapper extends BaseMapper<
        SubTask, SubTaskCreateDto, SubTaskUpdateDto, SubTaskDto> {
}
