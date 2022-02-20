package uz.bakhromjon.service.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import uz.bakhromjon.criteria.TaskCriteria;
import uz.bakhromjon.dto.task.TaskCreateDto;
import uz.bakhromjon.dto.task.TaskDto;
import uz.bakhromjon.dto.task.TaskUpdateDto;
import uz.bakhromjon.entity.task.Task;
import uz.bakhromjon.exceptions.NotFoundException;
import uz.bakhromjon.exceptions.UserNotFoundException;
import uz.bakhromjon.mapper.TaskMapper;
import uz.bakhromjon.repository.TaskRepository;
import uz.bakhromjon.service.BaseAbstractService;
import uz.bakhromjon.service.BaseCrudService;
import uz.bakhromjon.service.BaseShowService;

import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Bakhromjon Fri, 9:42 PM 2/18/2022
 */
@Service
public class TaskService extends BaseAbstractService<TaskRepository, TaskMapper>
        implements BaseCrudService<TaskCreateDto, TaskUpdateDto, Long>, BaseShowService<TaskDto, TaskCriteria, Long> {

    public TaskService(TaskRepository repository, TaskMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(TaskCreateDto taskCreateDto) {
        Task task = mapper.fromCreateDto(taskCreateDto);
        // TODO: 2/19/2022 add some check
        repository.save(task);
        return task.getId();
    }

    @Override
    public void delete(Long id) {
        repository.delete(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public void update(TaskUpdateDto taskUpdateDto) {
        Task task = repository.findById(taskUpdateDto.getId()).orElseThrow(() -> new NotFoundException("Not Found"));
        String title = (taskUpdateDto.getTitle().isBlank()) ? task.getTitle() : taskUpdateDto.getTitle();
        Date deadline = (Objects.isNull(taskUpdateDto.getDeadline())) ? task.getDeadline() : taskUpdateDto.getDeadline();
        String description = (taskUpdateDto.getDescription().isBlank()) ? task.getDescription() : taskUpdateDto.getDescription();
        boolean completed = (taskUpdateDto.isCompleted()) ? task.isCompleted() : taskUpdateDto.isCompleted();

        repository.update(title, deadline, description, completed);
    }

    @Override
    public List<TaskDto> list(TaskCriteria criteria) {
        List<Task> all = repository.findAll();
        return mapper.toDto(all);
    }

    @Override
    public TaskDto get(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        return mapper.toDto(task);
    }
}
