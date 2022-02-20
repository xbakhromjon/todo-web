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
public class TaskUpdateDto extends BaseAbstractDto {
    private String title;
    private Date deadline;
    private String description;
    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    @Builder
    public TaskUpdateDto(Long id, String title, Date deadline, String description, boolean completed) {
        super(id);
        this.title = title;
        this.deadline = deadline;
        this.description = description;
        this.completed = completed;
    }
}
