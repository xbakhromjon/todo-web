package uz.bakhromjon.service.user;

import org.springframework.stereotype.Service;
import uz.bakhromjon.criteria.UserCriteria;
import uz.bakhromjon.dto.user.UserCreateDto;
import uz.bakhromjon.dto.user.UserDto;
import uz.bakhromjon.dto.user.UserUpdateDto;
import uz.bakhromjon.entity.user.AuthUser;
import uz.bakhromjon.exceptions.UserNotFoundException;
import uz.bakhromjon.mapper.UserMapper;
import uz.bakhromjon.repository.UserRepository;
import uz.bakhromjon.service.BaseAbstractService;
import uz.bakhromjon.service.BaseCrudService;
import uz.bakhromjon.service.BaseShowService;

import java.util.List;

/**
 * @author Bakhromjon Fri, 5:35 PM 2/18/2022
 */
@Service
public class UserService extends BaseAbstractService<UserRepository, UserMapper>
        implements BaseCrudService<UserCreateDto, UserUpdateDto, Long>, BaseShowService<UserDto, UserCriteria, Long> {
    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void update(UserUpdateDto updateDto) {
        AuthUser authUser = repository.findById(updateDto.getId()).orElseThrow(() -> new UserNotFoundException("User Not found"));
        String username = (updateDto.getUsername().isBlank()) ? authUser.getUsername() : updateDto.getUsername();
        String email = (updateDto.getEmail().isBlank()) ? authUser.getEmail() : updateDto.getEmail();
        String avatar = (updateDto.getAvatar().isBlank()) ? authUser.getAvatar() : updateDto.getAvatar();
        repository.update(username, email, avatar);
    }

    @Override
    public List<UserDto> list(UserCriteria criteria) {
        List<AuthUser> all = repository.findAllByDeleted();
        return mapper.toDto(all);
    }

    @Override
    public UserDto get(Long id) {
        AuthUser authUser = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapper.toDto(authUser);
    }
}
