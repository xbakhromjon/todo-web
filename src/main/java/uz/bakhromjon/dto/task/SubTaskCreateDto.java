package uz.bakhromjon.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.bakhromjon.dto.BaseDto;
import uz.bakhromjon.entity.task.Task;

import java.util.Date;

/**
 * @author Bakhromjon Fri, 9:05 PM 2/18/2022
 */

@Setter
@Getter
@AllArgsConstructor
@Builder
public class SubTaskCreateDto implements BaseDto {
    private String title;
    private Date deadline;
    private String description;
    private Task task;
}
