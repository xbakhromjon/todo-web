package uz.bakhromjon.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.bakhromjon.dto.BaseAbstractDto;

import java.util.Date;

/**
 * @author Bakhromjon Fri, 9:06 PM 2/18/2022
 */
@Setter
@Getter
public class SubTaskUpdateDto extends BaseAbstractDto {
    private String title;
    private Date deadline;
    private String description;
    private boolean completed;


    @Builder
    public SubTaskUpdateDto(Long id, String title, Date deadline, String description, boolean completed) {
        super(id);
        this.title = title;
        this.deadline = deadline;
        this.description = description;
        this.completed = completed;
    }
}
