package uz.bakhromjon.service.user;

import org.springframework.stereotype.Service;
import uz.bakhromjon.criteria.UserCriteria;
import uz.bakhromjon.dto.user.UserCreateDto;
import uz.bakhromjon.dto.user.UserDto;
import uz.bakhromjon.dto.user.UserUpdateDto;
import uz.bakhromjon.mapper.UserMapper;
import uz.bakhromjon.repository.UserRepository;
import uz.bakhromjon.service.BaseAbstractService;
import uz.bakhromjon.service.BaseCrudService;
import uz.bakhromjon.service.BaseService;

import java.util.List;

/**
 * @author Bakhromjon Fri, 5:35 PM 2/18/2022
 */
@Service
public class UserService extends BaseAbstractService<UserRepository, UserMapper>
        implements BaseCrudService<UserCreateDto, UserUpdateDto, Long>, BaseService<UserDto, UserCriteria, Long> {
    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public Void delete(Long aLong) {
        return null;
    }

    @Override
    public Void update(UserUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<UserDto> list(UserCriteria criteria) {
        return null;
    }

    @Override
    public UserDto get(Long aLong) {
        return null;
    }
}
