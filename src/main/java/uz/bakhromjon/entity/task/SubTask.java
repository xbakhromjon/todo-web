package uz.bakhromjon.entity.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.bakhromjon.entity.Auditable;
import uz.bakhromjon.entity.task.Task;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @author Bakhromjon Fri, 8:35 PM 2/18/2022
 */
@Getter
@Setter
@Entity
public class SubTask extends Auditable {
    private String title;
    private Date deadline;
    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    private Task task;

    @Builder
    public SubTask(Long id, Date createdAt, Long createdBy, Date updatedAt, Long updatedBy, String title, Date deadline, String description, boolean completed, Task task) {
        super(id, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.deadline = deadline;
        this.description = description;
        this.completed = completed;
        this.task = task;
    }

    public SubTask() {
    }
}
