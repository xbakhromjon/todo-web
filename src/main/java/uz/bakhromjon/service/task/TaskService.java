package uz.bakhromjon.service.task;

import uz.bakhromjon.criteria.TaskCriteria;
import uz.bakhromjon.dto.task.TaskCreateDto;
import uz.bakhromjon.dto.task.TaskDto;
import uz.bakhromjon.dto.task.TaskUpdateDto;
import uz.bakhromjon.mapper.TaskMapper;
import uz.bakhromjon.repository.TaskRepository;
import uz.bakhromjon.service.BaseAbstractService;
import uz.bakhromjon.service.BaseCrudService;
import uz.bakhromjon.service.BaseService;

import java.util.List;

/**
 * @author Bakhromjon Fri, 9:42 PM 2/18/2022
 */
public class TaskService extends BaseAbstractService<TaskRepository, TaskMapper>
        implements BaseCrudService<TaskCreateDto, TaskUpdateDto, Long>, BaseService<TaskDto, TaskCriteria, Long> {

    public TaskService(TaskRepository repository, TaskMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(TaskCreateDto taskCreateDto) {
        return null;
    }

    @Override
    public Void delete(Long aLong) {
        return null;
    }

    @Override
    public Void update(TaskUpdateDto taskUpdateDto) {
        return null;
    }

    @Override
    public List<TaskDto> list(TaskCriteria criteria) {
        return null;
    }

    @Override
    public TaskDto get(Long aLong) {
        return null;
    }
}
