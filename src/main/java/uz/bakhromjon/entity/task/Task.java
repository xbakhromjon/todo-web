package uz.bakhromjon.entity.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.bakhromjon.entity.Auditable;
import uz.bakhromjon.entity.user.AuthUser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Bakhromjon Fri, 8:10 PM 2/18/2022
 */
@Setter
@Getter
@Entity
public class Task  extends Auditable {
    private String title;
    private Date deadline;
    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUser user;

    @OneToMany(mappedBy = "task")
    private List<SubTask> subTasks;

    @Builder
    public Task(Long id, Date createdAt, Long createdBy, Date updatedAt, Long updatedBy, String title, Date deadline, String description, boolean completed, AuthUser user, List<SubTask> subTasks) {
        super(id, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.deadline = deadline;
        this.description = description;
        this.completed = completed;
        this.user = user;
        this.subTasks = subTasks;
    }

    public Task() {
    }
}
