package uz.bakhromjon.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.bakhromjon.dto.BaseDto;
import uz.bakhromjon.entity.user.AuthUser;

import java.util.Date;

/**
 * @author Bakhromjon Fri, 9:05 PM 2/18/2022
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
public class TaskCreateDto implements BaseDto {
    private String title;
    private Date deadline;
    private String description;
    private AuthUser user;
}
