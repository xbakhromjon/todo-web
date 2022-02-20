package uz.bakhromjon.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.bakhromjon.dto.user.UserCreateDto;
import uz.bakhromjon.dto.user.UserDto;
import uz.bakhromjon.dto.user.UserUpdateDto;
import uz.bakhromjon.entity.user.AuthUser;

/**
 * @author Bakhromjon Fri, 9:23 PM 2/18/2022
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<
        AuthUser, UserCreateDto, UserUpdateDto, UserDto> {
    @Override
    @Mapping(target = "avatar", ignore = true)
    AuthUser fromCreateDto(UserCreateDto userCreateDto);

    @Override
    @Mapping(target = "avatar", ignore = true)
    AuthUser fromUpdateDto(UserUpdateDto updateDto);
}
