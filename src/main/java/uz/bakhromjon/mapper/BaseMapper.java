package uz.bakhromjon.mapper;

import org.springframework.stereotype.Component;
import uz.bakhromjon.dto.BaseAbstractDto;
import uz.bakhromjon.dto.BaseDto;
import uz.bakhromjon.entity.BaseEntity;

import java.util.List;

/**
 * @author Bakhromjon Fri, 9:23 PM 2/18/2022
 */
public interface BaseMapper<
        E extends BaseEntity,
        CD extends BaseDto,
        UD extends BaseAbstractDto,
        D extends BaseAbstractDto> extends Mapper {

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD ud);

    D toDto(E e);

    List<D> toDto(List<E> e);
}
