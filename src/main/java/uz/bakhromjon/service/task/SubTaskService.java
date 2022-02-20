package uz.bakhromjon.service.task;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import uz.bakhromjon.criteria.SubTaskCriteria;
import uz.bakhromjon.criteria.TaskCriteria;
import uz.bakhromjon.dto.task.*;
import uz.bakhromjon.entity.task.SubTask;
import uz.bakhromjon.entity.task.Task;
import uz.bakhromjon.exceptions.NotFoundException;
import uz.bakhromjon.exceptions.UserNotFoundException;
import uz.bakhromjon.mapper.SubTaskMapper;
import uz.bakhromjon.repository.SubTaskRepository;
import uz.bakhromjon.service.BaseAbstractService;
import uz.bakhromjon.service.BaseCrudService;
import uz.bakhromjon.service.BaseShowService;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Bakhromjon Fri, 9:42 PM 2/18/2022
 */
@Service
public class SubTaskService extends BaseAbstractService<SubTaskRepository, SubTaskMapper>
        implements BaseCrudService<SubTaskCreateDto, SubTaskUpdateDto, Long>, BaseShowService<SubTaskDto, SubTaskCriteria, Long> {

    public SubTaskService(SubTaskRepository repository, SubTaskMapper mapper) {
        super(repository, mapper);
    }


    @Override
    public Long create(SubTaskCreateDto taskCreateDto) {
        SubTask task = mapper.fromCreateDto(taskCreateDto);
        // TODO: 2/19/2022 add some check
        repository.save(task);
        return task.getId();
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        repository.delete(id);
    }

    @Override
    public void update(SubTaskUpdateDto subTaskUpdateDto) {
        SubTask task = repository.findById(subTaskUpdateDto.getId()).orElseThrow(() -> new NotFoundException("Not Found"));
        String title = (subTaskUpdateDto.getTitle().isBlank()) ? task.getTitle() : subTaskUpdateDto.getTitle();
        Date deadline = (Objects.isNull(subTaskUpdateDto.getDeadline())) ? task.getDeadline() : subTaskUpdateDto.getDeadline();
        String description = (subTaskUpdateDto.getDescription().isBlank()) ? task.getDescription() : subTaskUpdateDto.getDescription();
        boolean completed = (subTaskUpdateDto.isCompleted()) ? task.isCompleted() : subTaskUpdateDto.isCompleted();

        repository.update(title, deadline, description, completed);
    }

    @Override
    public List<SubTaskDto> list(SubTaskCriteria criteria) {
        List<SubTask> all = repository.findAll();
        return mapper.toDto(all);
    }

    @Override
    public SubTaskDto get(Long id) {
        SubTask task = repository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        return mapper.toDto(task);
    }
}
