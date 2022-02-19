package uz.bakhromjon.service.task;

import uz.bakhromjon.criteria.SubTaskCriteria;
import uz.bakhromjon.criteria.TaskCriteria;
import uz.bakhromjon.dto.task.*;
import uz.bakhromjon.mapper.SubTaskMapper;
import uz.bakhromjon.mapper.TaskMapper;
import uz.bakhromjon.repository.SubTaskRepository;
import uz.bakhromjon.repository.TaskRepository;
import uz.bakhromjon.service.BaseAbstractService;
import uz.bakhromjon.service.BaseCrudService;
import uz.bakhromjon.service.BaseService;

import java.util.List;

/**
 * @author Bakhromjon Fri, 9:42 PM 2/18/2022
 */
public class SubTaskService extends BaseAbstractService<SubTaskRepository, SubTaskMapper>
        implements BaseCrudService<SubTaskCreateDto, SubTaskUpdateDto, Long>, BaseService<SubTaskDto, SubTaskCriteria, Long> {

    public SubTaskService(SubTaskRepository repository, SubTaskMapper mapper) {
        super(repository, mapper);
    }


    @Override
    public Long create(SubTaskCreateDto subTaskCreateDto) {
        return null;
    }

    @Override
    public Void delete(Long aLong) {
        return null;
    }

    @Override
    public Void update(SubTaskUpdateDto subTaskUpdateDto) {
        return null;
    }

    @Override
    public List<SubTaskDto> list(SubTaskCriteria criteria) {
        return null;
    }

    @Override
    public SubTaskDto get(Long aLong) {
        return null;
    }
}
